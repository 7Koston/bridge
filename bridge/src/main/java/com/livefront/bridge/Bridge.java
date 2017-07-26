package com.livefront.bridge;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Bridge {

    private static BridgeDelegate sDelegate;

    private static void checkInitialization() {
        if (sDelegate == null) {
            throw new IllegalStateException(
                    "You must first call initialize before calling any other methods");
        }
    }

    /**
     * Initializes the framework used to save and restore data and route it to a location free from
     * {@link android.os.TransactionTooLargeException}. The actual state saving and restoration
     * of each object will be performed by the provided {@link SavedStateHandler}.
     *
     * @param context           an application {@link Context} necessary for saving state to disk
     * @param savedStateHandler used to do the actual state saving and restoring for a given object
     */
    public static void initialize(@NonNull Context context,
                                  @NonNull SavedStateHandler savedStateHandler) {
        sDelegate = new BridgeDelegate(context, savedStateHandler);
    }

    /**
     * Restores the state of the given target object based on tracking information stored in the
     * given {@link Bundle}. The actual saved data will be retrieved from a location in memory or
     * stored on disk.
     * <p>
     * It is required to call {@link #initialize(Context, SavedStateHandler)} before calling this
     * method.
     */
    public static void restoreInstanceState(@NonNull Object target, @Nullable Bundle state) {
        checkInitialization();
        sDelegate.restoreInstanceStateInternal(target, state);
    }

    /**
     * Saves the state of the given target object to a location in memory and disk and stores
     * tracking information in given {@link Bundle}.
     * <p>
     * It is required to call {@link #initialize(Context, SavedStateHandler)} before calling this
     * method.
     */
    public static void saveInstanceState(@NonNull Object target, @NonNull Bundle state) {
        checkInitialization();
        sDelegate.saveInstanceStateInternal(target, state);
    }

}