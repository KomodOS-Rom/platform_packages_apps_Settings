/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.support.annotation.VisibleForTesting;

import com.android.settings.R;

public class KomodoVersionDialogController {

    @VisibleForTesting
    private static final int KOMODO_VERSION_VALUE_ID = R.id.komodo_version;
    private static final String KOMODO_VERSION = "komodo_version";
    private static final String KOMODO_PROP = "ro.komodo.display.version";

    private final FirmwareVersionDialogFragment mDialog;
    private final Context mContext;

    public KomodoVersionDialogController(FirmwareVersionDialogFragment dialog) {
        mDialog = dialog;
        mContext = dialog.getContext();
    }

    public void initialize() {
         mDialog.setText(KOMODO_VERSION_VALUE_ID, SystemProperties.get(KOMODO_PROP,
                mContext.getResources().getString(R.string.device_info_default)));
    }
}
