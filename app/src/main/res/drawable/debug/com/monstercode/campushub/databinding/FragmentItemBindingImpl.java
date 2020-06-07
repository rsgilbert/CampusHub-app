package com.monstercode.campushub.databinding;
import com.monstercode.campushub.R;
import com.monstercode.campushub.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentItemBindingImpl extends FragmentItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.more_vert, 5);
        sViewsWithIds.put(R.id.more_horiz, 6);
        sViewsWithIds.put(R.id.update, 7);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.RelativeLayout) bindings[2]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[6]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[7]
            , (androidx.viewpager2.widget.ViewPager2) bindings[1]
            );
        this.infoLayout.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.price.setTag(null);
        this.priceTitle.setTag(null);
        this.viewPager.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.itemViewModel == variableId) {
            setItemViewModel((com.monstercode.campushub.item.ItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItemViewModel(@Nullable com.monstercode.campushub.item.ItemViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItemViewModelItemLiveData((androidx.lifecycle.LiveData<com.monstercode.campushub.domain.Item>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItemViewModelItemLiveData(androidx.lifecycle.LiveData<com.monstercode.campushub.domain.Item> ItemViewModelItemLiveData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String priceAndroidStringItemPriceItemViewModelItemLiveDataPrice = null;
        com.monstercode.campushub.item.ItemViewModel itemViewModel = mItemViewModel;
        java.util.List<com.monstercode.campushub.domain.Picture> itemViewModelItemLiveDataPictures = null;
        long itemViewModelItemLiveDataPrice = 0;
        androidx.lifecycle.LiveData<com.monstercode.campushub.domain.Item> itemViewModelItemLiveData = null;
        java.lang.String itemViewModelItemLiveDataName = null;
        com.monstercode.campushub.domain.Item itemViewModelItemLiveDataGetValue = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (itemViewModel != null) {
                    // read itemViewModel.itemLiveData
                    itemViewModelItemLiveData = itemViewModel.getItemLiveData();
                }
                updateLiveDataRegistration(0, itemViewModelItemLiveData);


                if (itemViewModelItemLiveData != null) {
                    // read itemViewModel.itemLiveData.getValue()
                    itemViewModelItemLiveDataGetValue = itemViewModelItemLiveData.getValue();
                }


                if (itemViewModelItemLiveDataGetValue != null) {
                    // read itemViewModel.itemLiveData.getValue().pictures
                    itemViewModelItemLiveDataPictures = itemViewModelItemLiveDataGetValue.getPictures();
                    // read itemViewModel.itemLiveData.getValue().price
                    itemViewModelItemLiveDataPrice = itemViewModelItemLiveDataGetValue.getPrice();
                    // read itemViewModel.itemLiveData.getValue().name
                    itemViewModelItemLiveDataName = itemViewModelItemLiveDataGetValue.getName();
                }


                // read @android:string/item_price
                priceAndroidStringItemPriceItemViewModelItemLiveDataPrice = price.getResources().getString(R.string.item_price, itemViewModelItemLiveDataPrice);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            com.monstercode.campushub.BindingAdaptersKt.addClickAnimation(this.infoLayout, true);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.price, priceAndroidStringItemPriceItemViewModelItemLiveDataPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.priceTitle, itemViewModelItemLiveDataName);
            com.monstercode.campushub.BindingAdaptersKt.bindPictureList(this.viewPager, itemViewModelItemLiveDataPictures);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): itemViewModel.itemLiveData
        flag 1 (0x2L): itemViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}