package com.technosavy.showmedistance.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import java.util.Map;
import java.util.Set;

/**
 * @author Nayanesh Gupte
 */
public class AppPreferences {

    private SharedPreferences mPreferences;

    /**
     * Constructor to initialize SharedPreferences object with default preferences.
     *
     * @param context Represents current state of the application/object.
     */
    public AppPreferences(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Retrieve and hold the contents of the preferences file 'name', returning a SharedPreferences through which you can retrieve and
     * modify its values.
     *
     * @param context Represents current state of the application/object
     * @param name    Desired preferences file name.
     * @param mode    Operating mode like MODE_PRIVATE,MODE_WORLD_READABLE,etc.
     */
    public AppPreferences(Context context, String name, int mode) {
        mPreferences = context.getSharedPreferences(name, mode);
    }

    /**
     * Sets the default values from an XML preference file
     *
     * @param context   The context of the shared preferences.
     * @param resId     The resource ID of the preference XML file.
     * @param readAgain Whether to re-read the default values.
     * @throws Exception if context is null or unable to set default values.
     */

    public void setDefaultValues(Context context, int resId, boolean readAgain) {
        PreferenceManager.setDefaultValues(context, resId, readAgain);
    }

    /**
     * Set a String value in the preferences.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @throws Exception if key or value is null.
     */
    public void putString(String key, String value) {
        try {
            Editor prefEdit = mPreferences.edit();
            prefEdit.putString(key, value);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve a String value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a String.
     */
    public String getString(String key, String defValue) throws ClassCastException {
        return mPreferences.getString(key, defValue);
    }

    /**
     * Set a Integer value in the preferences.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @throws Exception if key or value is null.
     */
    public void putInt(String key, int value) {
        try {
            Editor prefEdit = mPreferences.edit();
            prefEdit.putInt(key, value);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve a Integer value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a int.
     */
    public int getInt(String key, int defValue) throws ClassCastException {
        return mPreferences.getInt(key, defValue);
    }

    /**
     * Set a Long value in the preferences.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @throws Exception if key or value is null.
     */
    public void putLong(String key, long value) {
        try {
            Editor prefEdit = mPreferences.edit();
            prefEdit.putLong(key, value);
            prefEdit.commit();
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * Retrieve a Long value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a long.
     */
    public long getLong(String key, long defValue) throws ClassCastException {
        return mPreferences.getLong(key, defValue);
    }

    /**
     * Set a Boolean value in the preferences.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @throws Exception if key or value is null.
     */
    public void putBoolean(String key, Boolean value) {
        try {
            Editor prefEdit = mPreferences.edit();
            prefEdit.putBoolean(key, value);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve a Boolean value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a boolean.
     */
    public boolean getBoolean(String key, boolean defValue) throws ClassCastException {
        return mPreferences.getBoolean(key, defValue);
    }

    /**
     * Set a Float value in the preferences.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @throws Exception if key or value is null.
     */
    public void putFloat(String key, float value) {
        try {
            Editor prefEdit = mPreferences.edit();
            prefEdit.putFloat(key, value);
            prefEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve a Float value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a float.
     */
    public float getFloat(String key, float defValue) throws ClassCastException {
        return mPreferences.getFloat(key, defValue);
    }

    /**
     * Retrieve all values from the preferences.
     *
     * @return Map<String,?> containing all values from Preferences.
     * @throws NullPointerException if no data in preferences.
     */
    public Map<String, ?> getAll() throws NullPointerException {
        return mPreferences.getAll();
    }

    /**
     * Checks whether the preferences contains a preference.
     *
     * @param key The name of the preference to check.
     * @return true if the preference exists in the preferences, otherwise. false.
     * @throws Exception if key is null.
     */
    public Boolean contains(String key) {
        return mPreferences.contains(key);
    }

    /**
     * Method to remove all values from preferences.
     *
     * @throws Exception if <code>mPreferences</code> is null.
     */
    public void clearPreferences() {
        try {
            Editor prefEdit = mPreferences.edit();
            prefEdit.clear();
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to remove key
     *
     * @param key The name of the preference to remove.
     * @throws Exception if key is null.
     */
    public void removeKey(String key) {
        try {
            Editor prefEdit = mPreferences.edit();
            prefEdit.remove(key);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set a {@code Set<String>} in the preferences.
     *
     * @param key The name of the preference to modify.
     * @param set The new value for the preference.
     * @throws Exception if key or value is null.
     */
    public void putStringSet(String key, Set<String> set) {
        try {
            Editor prefEdit = mPreferences.edit();
            prefEdit.putStringSet(key, set);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Retrieve a {@code Set<String>} from the preferences.
     *
     * @param key the name of the preference to retrieve.
     * @param set the default value for the preference.
     * @return Returns the preference value if it exists, or defValue.
     */
    public Set<String> getStringSet(String key, Set<String> set) {
        return mPreferences.getStringSet(key, set);
    }

}
