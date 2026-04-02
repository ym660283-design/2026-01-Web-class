$sourceDir = Join-Path $PSScriptRoot ".."
$targetDir = "C:\xampp\tomcat\webapps\ROOT"

if (-not (Test-Path -LiteralPath $sourceDir)) {
    Write-Error "Source directory not found: $sourceDir"
    exit 1
}

if (-not (Test-Path -LiteralPath $targetDir)) {
    Write-Error "Target directory not found: $targetDir"
    exit 1
}

function Sync-JspFile {
    param(
        [Parameter(Mandatory = $true)]
        [string]$Path
    )

    if (-not (Test-Path -LiteralPath $Path)) {
        return
    }

    if ([System.IO.Path]::GetExtension($Path) -ne ".jsp") {
        return
    }

    $fileName = [System.IO.Path]::GetFileName($Path)
    $destination = Join-Path $targetDir $fileName
    Copy-Item -LiteralPath $Path -Destination $destination -Force
    Write-Host "Synced $fileName"
}

Get-ChildItem -LiteralPath $sourceDir -Filter *.jsp -File -Recurse | ForEach-Object {
    Sync-JspFile -Path $_.FullName
}

$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = (Resolve-Path -LiteralPath $sourceDir).Path
$watcher.Filter = "*.jsp"
$watcher.IncludeSubdirectories = $true
$watcher.NotifyFilter = [System.IO.NotifyFilters]'FileName, LastWrite, CreationTime'
$watcher.EnableRaisingEvents = $true

$action = {
    Start-Sleep -Milliseconds 150
    Sync-JspFile -Path $Event.SourceEventArgs.FullPath
}

Register-ObjectEvent -InputObject $watcher -EventName Changed -Action $action | Out-Null
Register-ObjectEvent -InputObject $watcher -EventName Created -Action $action | Out-Null
Register-ObjectEvent -InputObject $watcher -EventName Renamed -Action $action | Out-Null

Write-Host "Watching JSP files in $sourceDir"
Write-Host "Deploying to $targetDir"

while ($true) {
    Wait-Event | Out-Null
}
