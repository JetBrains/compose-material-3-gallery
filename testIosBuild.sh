#!/bin/sh

args_string=""

# Loop through the arguments
for arg in "$@"
do
    # Append the argument and a comma
    args_string+="${arg},"
done

# Remove the trailing comma
args_string=${args_string%,}


export CUSTOM_PARAMS="$args_string"
xcodebuild -project iosApp/iosApp.xcodeproj -scheme iosApp -configuration Debug -destination 'generic/platform=iOS Simulator' -allowProvisioningDeviceRegistration -allowProvisioningUpdates ARCHS=arm64