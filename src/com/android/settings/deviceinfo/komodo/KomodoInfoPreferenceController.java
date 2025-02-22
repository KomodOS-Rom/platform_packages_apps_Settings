/*
 * Copyright (C) 2018 Havoc-OS
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

package com.android.settings.deviceinfo.komodo;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.text.TextUtils;

import com.android.settings.R;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

public class KomodoInfoPreferenceController extends AbstractPreferenceController implements
        PreferenceControllerMixin {

    private final static String KOMODO_INFO_KEY = "komodo_info";
    private static final String KOMODO_VERSION = "ro.komodo.version";

    private final Fragment mFragment;

    public KomodoInfoPreferenceController(Context context, Fragment fragment) {
        super(context);

        mFragment = fragment;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final Preference pref = screen.findPreference(getPreferenceKey());
        if (pref != null) {
            pref.setSummary(SystemProperties.get(KOMODO_VERSION,
                mContext.getResources().getString(R.string.device_info_default)));
        }
    }

    @Override
    public String getPreferenceKey() {
        return KOMODO_INFO_KEY;
    }

    @Override
    public boolean handlePreferenceTreeClick(Preference preference) {
        if (!TextUtils.equals(preference.getKey(), getPreferenceKey())) {
            return false;
        }

        KomodoInfoDialogFragment.show(mFragment);
        return true;
    }
}
