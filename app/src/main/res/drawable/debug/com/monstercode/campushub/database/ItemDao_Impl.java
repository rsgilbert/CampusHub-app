package com.monstercode.campushub.database;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ItemDao_Impl implements ItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfDatabaseItem;

  private final EntityInsertionAdapter __insertionAdapterOfDatabasePicture;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOne;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOnePicture;

  public ItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDatabaseItem = new EntityInsertionAdapter<DatabaseItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `DatabaseItem`(`_id`,`name`,`price`,`userId`,`displayPicture`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DatabaseItem value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getPrice());
        if (value.getUserId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserId());
        }
        if (value.getDisplayPicture() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDisplayPicture());
        }
      }
    };
    this.__insertionAdapterOfDatabasePicture = new EntityInsertionAdapter<DatabasePicture>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `DatabasePicture`(`_id`,`pictureUrl`,`itemId`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DatabasePicture value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
        if (value.getPictureUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPictureUrl());
        }
        if (value.getItemId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemId());
        }
      }
    };
    this.__preparedStmtOfDeleteOne = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM DatabaseItem WHERE _id=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOnePicture = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM DatabasePicture WHERE _id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<DatabaseItem> items, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDatabaseItem.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insertOneItem(final DatabaseItem item, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDatabaseItem.insert(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insertPictures(final List<DatabasePicture> pictures,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDatabasePicture.insert(pictures);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insertOnePicture(final DatabasePicture picture,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDatabasePicture.insert(picture);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteOne(final String itemId, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOne.acquire();
        int _argIndex = 1;
        if (itemId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, itemId);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteOne.release(_stmt);
        }
      }
    }, p1);
  }

  @Override
  public Object deleteOnePicture(final String pictureId, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOnePicture.acquire();
        int _argIndex = 1;
        if (pictureId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, pictureId);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteOnePicture.release(_stmt);
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<DatabaseCompleteItem>> getItems() {
    final String _sql = "SELECT * FROM DatabaseItem";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"DatabasePicture","DatabaseItem"}, true, new Callable<List<DatabaseCompleteItem>>() {
      @Override
      public List<DatabaseCompleteItem> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
            final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
            final int _cursorIndexOfDisplayPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "displayPicture");
            final ArrayMap<String, ArrayList<DatabasePicture>> _collectionPictures = new ArrayMap<String, ArrayList<DatabasePicture>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<DatabasePicture> _tmpPicturesCollection = _collectionPictures.get(_tmpKey);
              if (_tmpPicturesCollection == null) {
                _tmpPicturesCollection = new ArrayList<DatabasePicture>();
                _collectionPictures.put(_tmpKey, _tmpPicturesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipDatabasePictureAscomMonstercodeCampushubDatabaseDatabasePicture(_collectionPictures);
            final List<DatabaseCompleteItem> _result = new ArrayList<DatabaseCompleteItem>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final DatabaseCompleteItem _item;
              final DatabaseItem _tmpItem;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfPrice) && _cursor.isNull(_cursorIndexOfUserId) && _cursor.isNull(_cursorIndexOfDisplayPicture))) {
                final String _tmp_id;
                _tmp_id = _cursor.getString(_cursorIndexOfId);
                final String _tmpName;
                _tmpName = _cursor.getString(_cursorIndexOfName);
                final long _tmpPrice;
                _tmpPrice = _cursor.getLong(_cursorIndexOfPrice);
                final String _tmpUserId;
                _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
                final String _tmpDisplayPicture;
                _tmpDisplayPicture = _cursor.getString(_cursorIndexOfDisplayPicture);
                _tmpItem = new DatabaseItem(_tmp_id,_tmpName,_tmpPrice,_tmpUserId,_tmpDisplayPicture);
              }  else  {
                _tmpItem = null;
              }
              ArrayList<DatabasePicture> _tmpPicturesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpPicturesCollection_1 = _collectionPictures.get(_tmpKey_1);
              if (_tmpPicturesCollection_1 == null) {
                _tmpPicturesCollection_1 = new ArrayList<DatabasePicture>();
              }
              _item = new DatabaseCompleteItem(_tmpItem,_tmpPicturesCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<DatabaseCompleteItem> getItem(final String itemId) {
    final String _sql = "SELECT * FROM DatabaseItem WHERE _id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"DatabasePicture","DatabaseItem"}, true, new Callable<DatabaseCompleteItem>() {
      @Override
      public DatabaseCompleteItem call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
            final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
            final int _cursorIndexOfDisplayPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "displayPicture");
            final ArrayMap<String, ArrayList<DatabasePicture>> _collectionPictures = new ArrayMap<String, ArrayList<DatabasePicture>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<DatabasePicture> _tmpPicturesCollection = _collectionPictures.get(_tmpKey);
              if (_tmpPicturesCollection == null) {
                _tmpPicturesCollection = new ArrayList<DatabasePicture>();
                _collectionPictures.put(_tmpKey, _tmpPicturesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipDatabasePictureAscomMonstercodeCampushubDatabaseDatabasePicture(_collectionPictures);
            final DatabaseCompleteItem _result;
            if(_cursor.moveToFirst()) {
              final DatabaseItem _tmpItem;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfPrice) && _cursor.isNull(_cursorIndexOfUserId) && _cursor.isNull(_cursorIndexOfDisplayPicture))) {
                final String _tmp_id;
                _tmp_id = _cursor.getString(_cursorIndexOfId);
                final String _tmpName;
                _tmpName = _cursor.getString(_cursorIndexOfName);
                final long _tmpPrice;
                _tmpPrice = _cursor.getLong(_cursorIndexOfPrice);
                final String _tmpUserId;
                _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
                final String _tmpDisplayPicture;
                _tmpDisplayPicture = _cursor.getString(_cursorIndexOfDisplayPicture);
                _tmpItem = new DatabaseItem(_tmp_id,_tmpName,_tmpPrice,_tmpUserId,_tmpDisplayPicture);
              }  else  {
                _tmpItem = null;
              }
              ArrayList<DatabasePicture> _tmpPicturesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpPicturesCollection_1 = _collectionPictures.get(_tmpKey_1);
              if (_tmpPicturesCollection_1 == null) {
                _tmpPicturesCollection_1 = new ArrayList<DatabasePicture>();
              }
              _result = new DatabaseCompleteItem(_tmpItem,_tmpPicturesCollection_1);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<DatabaseCompleteItem> getUserItems(final String userId) {
    final String _sql = "SELECT * FROM DatabaseItem WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"DatabasePicture","DatabaseItem"}, true, new Callable<DatabaseCompleteItem>() {
      @Override
      public DatabaseCompleteItem call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
            final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
            final int _cursorIndexOfDisplayPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "displayPicture");
            final ArrayMap<String, ArrayList<DatabasePicture>> _collectionPictures = new ArrayMap<String, ArrayList<DatabasePicture>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<DatabasePicture> _tmpPicturesCollection = _collectionPictures.get(_tmpKey);
              if (_tmpPicturesCollection == null) {
                _tmpPicturesCollection = new ArrayList<DatabasePicture>();
                _collectionPictures.put(_tmpKey, _tmpPicturesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipDatabasePictureAscomMonstercodeCampushubDatabaseDatabasePicture(_collectionPictures);
            final DatabaseCompleteItem _result;
            if(_cursor.moveToFirst()) {
              final DatabaseItem _tmpItem;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfPrice) && _cursor.isNull(_cursorIndexOfUserId) && _cursor.isNull(_cursorIndexOfDisplayPicture))) {
                final String _tmp_id;
                _tmp_id = _cursor.getString(_cursorIndexOfId);
                final String _tmpName;
                _tmpName = _cursor.getString(_cursorIndexOfName);
                final long _tmpPrice;
                _tmpPrice = _cursor.getLong(_cursorIndexOfPrice);
                final String _tmpUserId;
                _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
                final String _tmpDisplayPicture;
                _tmpDisplayPicture = _cursor.getString(_cursorIndexOfDisplayPicture);
                _tmpItem = new DatabaseItem(_tmp_id,_tmpName,_tmpPrice,_tmpUserId,_tmpDisplayPicture);
              }  else  {
                _tmpItem = null;
              }
              ArrayList<DatabasePicture> _tmpPicturesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpPicturesCollection_1 = _collectionPictures.get(_tmpKey_1);
              if (_tmpPicturesCollection_1 == null) {
                _tmpPicturesCollection_1 = new ArrayList<DatabasePicture>();
              }
              _result = new DatabaseCompleteItem(_tmpItem,_tmpPicturesCollection_1);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  private void __fetchRelationshipDatabasePictureAscomMonstercodeCampushubDatabaseDatabasePicture(final ArrayMap<String, ArrayList<DatabasePicture>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, ArrayList<DatabasePicture>> _tmpInnerMap = new ArrayMap<String, ArrayList<DatabasePicture>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _mapIndex = 0;
      int _tmpIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipDatabasePictureAscomMonstercodeCampushubDatabaseDatabasePicture(_tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, ArrayList<DatabasePicture>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipDatabasePictureAscomMonstercodeCampushubDatabaseDatabasePicture(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `_id`,`pictureUrl`,`itemId` FROM `DatabasePicture` WHERE `itemId` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "itemId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
      final int _cursorIndexOfPictureUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "pictureUrl");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
      while(_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_itemKeyIndex);
        ArrayList<DatabasePicture> _tmpCollection = _map.get(_tmpKey);
        if (_tmpCollection != null) {
          final DatabasePicture _item_1;
          final String _tmp_id;
          _tmp_id = _cursor.getString(_cursorIndexOfId);
          final String _tmpPictureUrl;
          _tmpPictureUrl = _cursor.getString(_cursorIndexOfPictureUrl);
          final String _tmpItemId;
          _tmpItemId = _cursor.getString(_cursorIndexOfItemId);
          _item_1 = new DatabasePicture(_tmp_id,_tmpPictureUrl,_tmpItemId);
          _tmpCollection.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
