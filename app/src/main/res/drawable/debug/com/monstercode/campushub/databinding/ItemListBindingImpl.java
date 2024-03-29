package com.monstercode.campushub.databinding;
import com.monstercode.campushub.R;
import com.monstercode.campushub.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemListBindingImpl extends ItemListBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ItemListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            );
        this.itemList.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.itemListViewModel == variableId) {
            setItemListViewModel((com.monstercode.campushub.itemlist.JourneysViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItemListViewModel(@Nullable com.monstercode.campushub.itemlist.JourneysViewModel JourneysViewModel) {
        this.mItemListViewModel = JourneysViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.itemListViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItemListViewModelItems((androidx.lifecycle.LiveData<java.util.List<com.monstercode.campushub.domain.Item>>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItemListViewModelItems(androidx.lifecycle.LiveData<java.util.List<com.monstercode.campushub.domain.Item>> ItemListViewModelItems, int fieldId) {
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
        androidx.lifecycle.LiveData<java.util.List<com.monstercode.campushub.domain.Item>> itemListViewModelItems = null;
        com.monstercode.campushub.itemlist.JourneysViewModel journeysViewModel = mItemListViewModel;
        java.util.List<com.monstercode.campushub.domain.Item> itemListViewModelItemsGetValue = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (journeysViewModel != null) {
                    // read itemListViewModel.items
                    itemListViewModelItems = journeysViewModel.getItems();
                }
                updateLiveDataRegistration(0, itemListViewModelItems);


                if (itemListViewModelItems != null) {
                    // read itemListViewModel.items.getValue()
                    itemListViewModelItemsGetValue = itemListViewModelItems.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.monstercode.campushub.BindingAdaptersKt.bindItemList(this.itemList, itemListViewModelItemsGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): itemListViewModel.items
        flag 1 (0x2L): itemListViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}