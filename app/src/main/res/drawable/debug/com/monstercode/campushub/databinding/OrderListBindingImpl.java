package com.monstercode.campushub.databinding;
import com.monstercode.campushub.R;
import com.monstercode.campushub.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class OrderListBindingImpl extends OrderListBinding  {

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
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public OrderListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private OrderListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.orderList.setTag(null);
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
        if (BR.orderListViewModel == variableId) {
            setOrderListViewModel((com.monstercode.campushub.orderlist.OrderListViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOrderListViewModel(@Nullable com.monstercode.campushub.orderlist.OrderListViewModel OrderListViewModel) {
        this.mOrderListViewModel = OrderListViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.orderListViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeOrderListViewModelOrders((androidx.lifecycle.LiveData<java.util.List<com.monstercode.campushub.domain.Order>>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeOrderListViewModelOrders(androidx.lifecycle.LiveData<java.util.List<com.monstercode.campushub.domain.Order>> OrderListViewModelOrders, int fieldId) {
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
        java.util.List<com.monstercode.campushub.domain.Order> orderListViewModelOrdersGetValue = null;
        androidx.lifecycle.LiveData<java.util.List<com.monstercode.campushub.domain.Order>> orderListViewModelOrders = null;
        com.monstercode.campushub.orderlist.OrderListViewModel orderListViewModel = mOrderListViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (orderListViewModel != null) {
                    // read orderListViewModel.orders
                    orderListViewModelOrders = orderListViewModel.getOrders();
                }
                updateLiveDataRegistration(0, orderListViewModelOrders);


                if (orderListViewModelOrders != null) {
                    // read orderListViewModel.orders.getValue()
                    orderListViewModelOrdersGetValue = orderListViewModelOrders.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            com.monstercode.campushub.BindingAdaptersKt.addDivider(this.orderList, true);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.monstercode.campushub.BindingAdaptersKt.bindOrderList(this.orderList, orderListViewModelOrdersGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): orderListViewModel.orders
        flag 1 (0x2L): orderListViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}