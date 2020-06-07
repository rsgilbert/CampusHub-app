package com.monstercode.campushub.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CampusHubDatabase_Impl extends CampusHubDatabase {
  private volatile ItemDao _itemDao;

  private volatile OrderDao _orderDao;

  private volatile PictureDao _pictureDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DatabaseItem` (`_id` TEXT NOT NULL, `name` TEXT NOT NULL, `price` INTEGER NOT NULL, `userId` TEXT NOT NULL, `displayPicture` TEXT, PRIMARY KEY(`_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DatabaseOrder` (`_id` TEXT NOT NULL, `itemId` TEXT NOT NULL, `time` INTEGER NOT NULL, `phoneNumber` TEXT NOT NULL, `hall` TEXT NOT NULL, `completed` INTEGER NOT NULL, PRIMARY KEY(`_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DatabasePicture` (`_id` TEXT NOT NULL, `pictureUrl` TEXT NOT NULL, `itemId` TEXT NOT NULL, PRIMARY KEY(`_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"3e11f74370fd4c3bf4c7ac9c9e43ff76\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `DatabaseItem`");
        _db.execSQL("DROP TABLE IF EXISTS `DatabaseOrder`");
        _db.execSQL("DROP TABLE IF EXISTS `DatabasePicture`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsDatabaseItem = new HashMap<String, TableInfo.Column>(5);
        _columnsDatabaseItem.put("_id", new TableInfo.Column("_id", "TEXT", true, 1));
        _columnsDatabaseItem.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsDatabaseItem.put("price", new TableInfo.Column("price", "INTEGER", true, 0));
        _columnsDatabaseItem.put("userId", new TableInfo.Column("userId", "TEXT", true, 0));
        _columnsDatabaseItem.put("displayPicture", new TableInfo.Column("displayPicture", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDatabaseItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDatabaseItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDatabaseItem = new TableInfo("DatabaseItem", _columnsDatabaseItem, _foreignKeysDatabaseItem, _indicesDatabaseItem);
        final TableInfo _existingDatabaseItem = TableInfo.read(_db, "DatabaseItem");
        if (! _infoDatabaseItem.equals(_existingDatabaseItem)) {
          throw new IllegalStateException("Migration didn't properly handle DatabaseItem(com.monstercode.campushub.database.DatabaseItem).\n"
                  + " Expected:\n" + _infoDatabaseItem + "\n"
                  + " Found:\n" + _existingDatabaseItem);
        }
        final HashMap<String, TableInfo.Column> _columnsDatabaseOrder = new HashMap<String, TableInfo.Column>(6);
        _columnsDatabaseOrder.put("_id", new TableInfo.Column("_id", "TEXT", true, 1));
        _columnsDatabaseOrder.put("itemId", new TableInfo.Column("itemId", "TEXT", true, 0));
        _columnsDatabaseOrder.put("time", new TableInfo.Column("time", "INTEGER", true, 0));
        _columnsDatabaseOrder.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0));
        _columnsDatabaseOrder.put("hall", new TableInfo.Column("hall", "TEXT", true, 0));
        _columnsDatabaseOrder.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDatabaseOrder = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDatabaseOrder = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDatabaseOrder = new TableInfo("DatabaseOrder", _columnsDatabaseOrder, _foreignKeysDatabaseOrder, _indicesDatabaseOrder);
        final TableInfo _existingDatabaseOrder = TableInfo.read(_db, "DatabaseOrder");
        if (! _infoDatabaseOrder.equals(_existingDatabaseOrder)) {
          throw new IllegalStateException("Migration didn't properly handle DatabaseOrder(com.monstercode.campushub.database.DatabaseOrder).\n"
                  + " Expected:\n" + _infoDatabaseOrder + "\n"
                  + " Found:\n" + _existingDatabaseOrder);
        }
        final HashMap<String, TableInfo.Column> _columnsDatabasePicture = new HashMap<String, TableInfo.Column>(3);
        _columnsDatabasePicture.put("_id", new TableInfo.Column("_id", "TEXT", true, 1));
        _columnsDatabasePicture.put("pictureUrl", new TableInfo.Column("pictureUrl", "TEXT", true, 0));
        _columnsDatabasePicture.put("itemId", new TableInfo.Column("itemId", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDatabasePicture = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDatabasePicture = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDatabasePicture = new TableInfo("DatabasePicture", _columnsDatabasePicture, _foreignKeysDatabasePicture, _indicesDatabasePicture);
        final TableInfo _existingDatabasePicture = TableInfo.read(_db, "DatabasePicture");
        if (! _infoDatabasePicture.equals(_existingDatabasePicture)) {
          throw new IllegalStateException("Migration didn't properly handle DatabasePicture(com.monstercode.campushub.database.DatabasePicture).\n"
                  + " Expected:\n" + _infoDatabasePicture + "\n"
                  + " Found:\n" + _existingDatabasePicture);
        }
      }
    }, "3e11f74370fd4c3bf4c7ac9c9e43ff76", "69b44867f31babb42210fbebb2985d01");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "DatabaseItem","DatabaseOrder","DatabasePicture");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `DatabaseItem`");
      _db.execSQL("DELETE FROM `DatabaseOrder`");
      _db.execSQL("DELETE FROM `DatabasePicture`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ItemDao getItemDao() {
    if (_itemDao != null) {
      return _itemDao;
    } else {
      synchronized(this) {
        if(_itemDao == null) {
          _itemDao = new ItemDao_Impl(this);
        }
        return _itemDao;
      }
    }
  }

  @Override
  public OrderDao getOrderDao() {
    if (_orderDao != null) {
      return _orderDao;
    } else {
      synchronized(this) {
        if(_orderDao == null) {
          _orderDao = new OrderDao_Impl(this);
        }
        return _orderDao;
      }
    }
  }

  @Override
  public PictureDao getPictureDao() {
    if (_pictureDao != null) {
      return _pictureDao;
    } else {
      synchronized(this) {
        if(_pictureDao == null) {
          _pictureDao = new PictureDao_Impl(this);
        }
        return _pictureDao;
      }
    }
  }
}
