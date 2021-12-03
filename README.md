# KioskMode-Android
Screen Pinning Android Lollipop without Rooting

### Set as Admin open CMD

    adb shell dpm set-device-owner net.derohimat.kioskmodesample/.AdminReceiver

### Remove Admin

    adb shell dpm remove-active-admin net.derohimat.kioskmodesample/.AdminReceiver

### Check Admin Status

    adb shell dumpsys device_policy

### If you want allow some apps
thanks for [yurik94](https://github.com/yurik94)

https://github.com/derohimat/KioskMode-Android/issues/2#issuecomment-434504722

    mDpm.setLockTaskPackages(
                        deviceAdmin, //deviceAdmin = new ComponentName(this, AdminReceiver.class);
                        whitelistedPackages); //String[]



### License
    Copyright 2016 Deni Rohimat
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
