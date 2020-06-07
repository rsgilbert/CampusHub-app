package com.monstercode.campushub;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.monstercode.campushub.databinding.ActivityMainBindingImpl;
import com.monstercode.campushub.databinding.DeleteDialogFragmentBindingImpl;
import com.monstercode.campushub.databinding.FragmentAccountBindingImpl;
import com.monstercode.campushub.databinding.FragmentItemBindingImpl;
import com.monstercode.campushub.databinding.FragmentItemOldBindingImpl;
import com.monstercode.campushub.databinding.FragmentLoginBindingImpl;
import com.monstercode.campushub.databinding.FragmentNewItemBindingImpl;
import com.monstercode.campushub.databinding.FragmentRegisterBindingImpl;
import com.monstercode.campushub.databinding.ItemListBindingImpl;
import com.monstercode.campushub.databinding.ItemListItemBindingImpl;
import com.monstercode.campushub.databinding.OrderListBindingImpl;
import com.monstercode.campushub.databinding.OrderListItemBindingImpl;
import com.monstercode.campushub.databinding.PictureListItemBindingImpl;
import com.monstercode.campushub.databinding.UpdateDialogBindingImpl;
import com.monstercode.campushub.databinding.UpdateNameDialogFragmentBindingImpl;
import com.monstercode.campushub.databinding.UpdatePriceDialogFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_DELETEDIALOGFRAGMENT = 2;

  private static final int LAYOUT_FRAGMENTACCOUNT = 3;

  private static final int LAYOUT_FRAGMENTITEM = 4;

  private static final int LAYOUT_FRAGMENTITEMOLD = 5;

  private static final int LAYOUT_FRAGMENTLOGIN = 6;

  private static final int LAYOUT_FRAGMENTNEWITEM = 7;

  private static final int LAYOUT_FRAGMENTREGISTER = 8;

  private static final int LAYOUT_ITEMLIST = 9;

  private static final int LAYOUT_ITEMLISTITEM = 10;

  private static final int LAYOUT_ORDERLIST = 11;

  private static final int LAYOUT_ORDERLISTITEM = 12;

  private static final int LAYOUT_PICTURELISTITEM = 13;

  private static final int LAYOUT_UPDATEDIALOG = 14;

  private static final int LAYOUT_UPDATENAMEDIALOGFRAGMENT = 15;

  private static final int LAYOUT_UPDATEPRICEDIALOGFRAGMENT = 16;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(16);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.delete_dialog_fragment, LAYOUT_DELETEDIALOGFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.fragment_account, LAYOUT_FRAGMENTACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.fragment_item, LAYOUT_FRAGMENTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.fragment_item_old, LAYOUT_FRAGMENTITEMOLD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.fragment_new_item, LAYOUT_FRAGMENTNEWITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.fragment_register, LAYOUT_FRAGMENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.item_list, LAYOUT_ITEMLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.item_list_item, LAYOUT_ITEMLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.order_list, LAYOUT_ORDERLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.order_list_item, LAYOUT_ORDERLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.picture_list_item, LAYOUT_PICTURELISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.update_dialog, LAYOUT_UPDATEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.update_name_dialog_fragment, LAYOUT_UPDATENAMEDIALOGFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.monstercode.campushub.R.layout.update_price_dialog_fragment, LAYOUT_UPDATEPRICEDIALOGFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_DELETEDIALOGFRAGMENT: {
          if ("layout/delete_dialog_fragment_0".equals(tag)) {
            return new DeleteDialogFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for delete_dialog_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTACCOUNT: {
          if ("layout/fragment_account_0".equals(tag)) {
            return new FragmentAccountBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_account is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTITEM: {
          if ("layout/fragment_item_0".equals(tag)) {
            return new FragmentItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTITEMOLD: {
          if ("layout/fragment_item_old_0".equals(tag)) {
            return new FragmentItemOldBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_item_old is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNEWITEM: {
          if ("layout/fragment_new_item_0".equals(tag)) {
            return new FragmentNewItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_new_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGISTER: {
          if ("layout/fragment_register_0".equals(tag)) {
            return new FragmentRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLIST: {
          if ("layout/item_list_0".equals(tag)) {
            return new ItemListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for journeys_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLISTITEM: {
          if ("layout/item_list_item_0".equals(tag)) {
            return new ItemListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for journeys_item is invalid. Received: " + tag);
        }
        case  LAYOUT_ORDERLIST: {
          if ("layout/order_list_0".equals(tag)) {
            return new OrderListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for order_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ORDERLISTITEM: {
          if ("layout/order_list_item_0".equals(tag)) {
            return new OrderListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for order_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PICTURELISTITEM: {
          if ("layout/picture_list_item_0".equals(tag)) {
            return new PictureListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for picture_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_UPDATEDIALOG: {
          if ("layout/update_dialog_0".equals(tag)) {
            return new UpdateDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for update_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_UPDATENAMEDIALOGFRAGMENT: {
          if ("layout/update_name_dialog_fragment_0".equals(tag)) {
            return new UpdateNameDialogFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for update_name_dialog_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_UPDATEPRICEDIALOGFRAGMENT: {
          if ("layout/update_price_dialog_fragment_0".equals(tag)) {
            return new UpdatePriceDialogFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for update_price_dialog_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(12);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "item");
      sKeys.put(2, "orderListViewModel");
      sKeys.put(3, "newItemViewModel");
      sKeys.put(4, "price");
      sKeys.put(5, "accountViewModel");
      sKeys.put(6, "name");
      sKeys.put(7, "itemListViewModel");
      sKeys.put(8, "itemViewModel");
      sKeys.put(9, "picture");
      sKeys.put(10, "order");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(16);

    static {
      sKeys.put("layout/activity_main_0", com.monstercode.campushub.R.layout.activity_main);
      sKeys.put("layout/delete_dialog_fragment_0", com.monstercode.campushub.R.layout.delete_dialog_fragment);
      sKeys.put("layout/fragment_account_0", com.monstercode.campushub.R.layout.fragment_account);
      sKeys.put("layout/fragment_item_0", com.monstercode.campushub.R.layout.fragment_item);
      sKeys.put("layout/fragment_item_old_0", com.monstercode.campushub.R.layout.fragment_item_old);
      sKeys.put("layout/fragment_login_0", com.monstercode.campushub.R.layout.fragment_login);
      sKeys.put("layout/fragment_new_item_0", com.monstercode.campushub.R.layout.fragment_new_item);
      sKeys.put("layout/fragment_register_0", com.monstercode.campushub.R.layout.fragment_register);
      sKeys.put("layout/item_list_0", com.monstercode.campushub.R.layout.item_list);
      sKeys.put("layout/item_list_item_0", com.monstercode.campushub.R.layout.item_list_item);
      sKeys.put("layout/order_list_0", com.monstercode.campushub.R.layout.order_list);
      sKeys.put("layout/order_list_item_0", com.monstercode.campushub.R.layout.order_list_item);
      sKeys.put("layout/picture_list_item_0", com.monstercode.campushub.R.layout.picture_list_item);
      sKeys.put("layout/update_dialog_0", com.monstercode.campushub.R.layout.update_dialog);
      sKeys.put("layout/update_name_dialog_fragment_0", com.monstercode.campushub.R.layout.update_name_dialog_fragment);
      sKeys.put("layout/update_price_dialog_fragment_0", com.monstercode.campushub.R.layout.update_price_dialog_fragment);
    }
  }
}
