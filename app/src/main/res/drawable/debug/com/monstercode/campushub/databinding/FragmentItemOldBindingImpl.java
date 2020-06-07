package com.monstercode.campushub.databinding;
import com.monstercode.campushub.R;
import com.monstercode.campushub.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentItemOldBindingImpl extends FragmentItemOldBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.more_vert, 6);
        sViewsWithIds.put(R.id.name_img, 7);
        sViewsWithIds.put(R.id.name_title, 8);
        sViewsWithIds.put(R.id.price_img, 9);
        sViewsWithIds.put(R.id.price_title, 10);
        sViewsWithIds.put(R.id.pencil, 11);
        sViewsWithIds.put(R.id.dark_line, 12);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentItemOldBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentItemOldBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[12]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[7]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[11]
            , (android.widget.TextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[9]
            , (android.widget.RelativeLayout) bindings[4]
            , (android.widget.TextView) bindings[10]
            , (androidx.viewpager2.widget.ViewPager2) bindings[1]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.name.setTag(null);
        this.nameLayout.setTag(null);
        this.price.setTag(null);
        this.priceLayout.setTag(null);
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
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, itemViewModelItemLiveDataName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.price, priceAndroidStringItemPriceItemViewModelItemLiveDataPrice);
            com.monstercode.campushub.BindingAdaptersKt.bindPictureList(this.viewPager, itemViewModelItemLiveDataPictures);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            com.monstercode.campushub.BindingAdaptersKt.addClickAnimation(this.nameLayout, true);
            com.monstercode.campushub.BindingAdaptersKt.addClickAnimation(this.priceLayout, true);
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