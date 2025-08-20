#!/bin/sh

args_string=""

has_kotlin_native_version=false
kotlin_version_value=""

# Loop through the arguments
for arg in "$@"
do
    case "$arg" in
        -Pkotlin.native.version=*)
            has_kotlin_native_version=true
            ;;
        -Pkotlin.version=*)
            kotlin_version_value="${arg#-Pkotlin.version=}"
            ;;
    esac

    args_string+="${arg},"
done

if [ "$has_kotlin_native_version" = false ] && [ -n "$kotlin_version_value" ]; then
    args_string+="-Pkotlin.native.version=${kotlin_version_value},"
fi

# Remove the trailing comma
args_string=${args_string%,}

export CUSTOM_PARAMS="$args_string"
echo "CUSTOM_PARAMS=${CUSTOM_PARAMS}"

xcodebuild -project iosApp/iosApp.xcodeproj -scheme iosApp -configuration Debug -destination 'generic/platform=iOS Simulator' -allowProvisioningDeviceRegistration -allowProvisioningUpdates ARCHS=arm64