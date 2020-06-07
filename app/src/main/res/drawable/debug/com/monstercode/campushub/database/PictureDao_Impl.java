package com.monstercode.campushub.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PictureDao_Impl implements PictureDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfDatabasePicture;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOne;

  public PictureDao_Impl(RoomDatabase __db) {
    this.__db = __db;
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
        final String _query = "DELETE FROM DatabasePicture WHERE _id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<DatabasePicture> pictures,
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
  public Object deleteOne(final String pictureId, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOne.acquire();
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
          __preparedStmtOfDeleteOne.release(_stmt);
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<DatabasePicture>> getPictureListLiveData() {
    final String _sql = "SELECT * FROM DatabasePicture";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"DatabasePicture"}, false, new Callable<List<DatabasePicture>>() {
      @Override
      public List<DatabasePicture> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfPictureUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "pictureUrl");
          final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
          final List<DatabasePicture> _result = new ArrayList<DatabasePicture>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DatabasePicture _item;
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final String _tmpPictureUrl;
            _tmpPictureUrl = _cursor.getString(_cursorIndexOfPictureUrl);
            final String _tmpItemId;
            _tmpItemId = _cursor.getString(_cursorIndexOfItemId);
            _item = new DatabasePicture(_tmp_id,_tmpPictureUrl,_tmpItemId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<DatabasePicture> getPicture(final String pictureId) {
    final String _sql = "SELECT * FROM DatabasePicture WHERE _id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (pictureId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pictureId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"DatabasePicture"}, false, new Callable<DatabasePicture>() {
      @Override
      public DatabasePicture call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfPictureUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "pictureUrl");
          final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
          final DatabasePicture _result;
          if(_cursor.moveToFirst()) {
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final String _tmpPictureUrl;
            _tmpPictureUrl = _cursor.getString(_cursorIndexOfPictureUrl);
            final String _tmpItemId;
            _tmpItemId = _cursor.getString(_cursorIndexOfItemId);
            _result = new DatabasePicture(_tmp_id,_tmpPictureUrl,_tmpItemId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DatabasePicture>> getItemPictures(final String itemId) {
    final String _sql = "SELECT * FROM DatabasePicture WHERE itemId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"DatabasePicture"}, false, new Callable<List<DatabasePicture>>() {
      @Override
      public List<DatabasePicture> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfPictureUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "pictureUrl");
          final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
          final List<DatabasePicture> _result = new ArrayList<DatabasePicture>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DatabasePicture _item;
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final String _tmpPictureUrl;
            _tmpPictureUrl = _cursor.getString(_cursorIndexOfPictureUrl);
            final String _tmpItemId;
            _tmpItemId = _cursor.getString(_cursorIndexOfItemId);
            _item = new DatabasePicture(_tmp_id,_tmpPictureUrl,_tmpItemId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
