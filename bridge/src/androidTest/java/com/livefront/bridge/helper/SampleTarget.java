package com.livefront.bridge.helper;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/**
 * A sample class that can be used as a target with {@link com.livefront.bridge.Bridge} by checking
 * for the {@link Saveable} interface in the {@link com.livefront.bridge.SavedStateHandler}.
 */
public final class SampleTarget implements Saveable {

  private static final String DATA_KEY = "data";

  private Data mData;

  public SampleTarget(@Nullable Data data) {
    mData = data;
  }

  //region Saveable
  @Override
  public void saveState(@NonNull Bundle bundle) {
    bundle.putParcelable(DATA_KEY, mData);
  }

  @Override
  public void restoreState(@Nullable Bundle bundle) {
    if (bundle == null) {
      return;
    }
    mData = bundle.getParcelable(DATA_KEY);
  }

  //region Equals and Hashcode
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleTarget that = (SampleTarget) o;
    return Objects.equals(mData, that.mData);
  }
  //endregion Saveable

  @Override
  public int hashCode() {
    return Objects.hash(mData);
  }

  @NonNull
  public Data getData() {
    return mData;
  }
  //endregion Equals and Hashcode
}
