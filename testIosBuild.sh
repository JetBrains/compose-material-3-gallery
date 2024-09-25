#!/bin/sh

args_string=""

# Loop through the arguments
for arg in "$@"
do
    # Append the argument and a comma
    args_string+="${arg},"

    # We need to add `-Pkotlin.native.version=...` to the arguments
    # Check if the current argument matches the pattern -Pcommunity.project.kotlin.version=*
    case "$arg" in
        -Pcommunity.project.kotlin.version=*)
            # Extract the value part after the '=' sign
            kotlin_version="${arg#-Pcommunity.project.kotlin.version=}"

            # Construct the new parameter with the extracted value
            new_param="-Pkotlin.native.version=${kotlin_version}"

            # Append the new parameter followed by a comma to args_string
            args_string+="${new_param},"
            ;;
        *)
            # For all other arguments, do nothing extra
            ;;
    esac
done


# Remove the trailing comma
args_string=${args_string%,}


export CUSTOM_PARAMS="$args_string"
echo "CUSTOM_PARAMS=${CUSTOM_PARAMS}"

xcodebuild -project iosApp/iosApp.xcodeproj -scheme iosApp -configuration Debug -destination 'generic/platform=iOS Simulator' -allowProvisioningDeviceRegistration -allowProvisioningUpdates ARCHS=arm64