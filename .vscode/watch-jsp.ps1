$workspaceDir = Resolve-Path -LiteralPath (Join-Path $PSScriptRoot "..")
$sourceDir = Join-Path $workspaceDir "Week 08\2. CalcJSP\CalcJSP\src\main\webapp"
$targetDir = "C:\xampp\tomcat\webapps\CalcJSP"

if (-not (Test-Path -LiteralPath $sourceDir)) {
    Write-Error "Source directory not found: $sourceDir"
    exit 1
}

if (-not (Test-Path -LiteralPath $targetDir)) {
    Write-Error "Target directory not found: $targetDir"
    exit 1
}

function Sync-WebFile {
    param(
        [Parameter(Mandatory = $true)]
        [string]$Path
    )

    if (-not (Test-Path -LiteralPath $Path)) {
        return
    }

    $extension = [System.IO.Path]::GetExtension($Path)
    if ($extension -notin @(".html", ".jsp", ".xml")) {
        return
    }

    $relativePath = [System.IO.Path]::GetRelativePath((Resolve-Path -LiteralPath $sourceDir).Path, $Path)
    $destination = Join-Path $targetDir $relativePath
    $destinationDir = Split-Path -Parent $destination

    if (-not (Test-Path -LiteralPath $destinationDir)) {
        New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
    }

    Copy-Item -LiteralPath $Path -Destination $destination -Force
    Write-Host "Synced $relativePath"
}

Get-ChildItem -LiteralPath $sourceDir -File -Recurse | ForEach-Object {
    Sync-WebFile -Path $_.FullName
}

$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = (Resolve-Path -LiteralPath $sourceDir).Path
$watcher.Filter = "*.*"
$watcher.IncludeSubdirectories = $true
$watcher.NotifyFilter = [System.IO.NotifyFilters]'FileName, LastWrite, CreationTime'
$watcher.EnableRaisingEvents = $true

$action = {
    Start-Sleep -Milliseconds 150
    Sync-WebFile -Path $Event.SourceEventArgs.FullPath
}

Register-ObjectEvent -InputObject $watcher -EventName Changed -Action $action | Out-Null
Register-ObjectEvent -InputObject $watcher -EventName Created -Action $action | Out-Null
Register-ObjectEvent -InputObject $watcher -EventName Renamed -Action $action | Out-Null

Write-Host "Watching web files in $sourceDir"
Write-Host "Deploying to $targetDir"

while ($true) {
    Wait-Event | Out-Null
}
