package com.example.lab5;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

    final String LOG_TAG = "myLogs";

    Button btnAdd, btnRead, btnClear, btnUpd, btnDel;
    EditText etPosition, etSalary, etID, etTubNum, etSurname, etName, etSecondName, etBirthDate, etWorkDate, etAddress, etPhone;

    DBHelper dbHelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnUpd = (Button) findViewById(R.id.btnUpd);
        btnUpd.setOnClickListener(this);

        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etPosition = (EditText) findViewById(R.id.etPosition);
        etBirthDate = (EditText) findViewById(R.id.etBirthDate);
        etWorkDate = (EditText) findViewById(R.id.etWorkDate);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etSecondName = (EditText) findViewById(R.id.etSecondName);
        etSalary = (EditText) findViewById(R.id.etSalary);
        etTubNum = (EditText) findViewById(R.id.etTubNum);
        etID = (EditText) findViewById(R.id.etID);

        dbHelper = new DBHelper(this);
    }

    public void onClick(View v) {

        ContentValues cv = new ContentValues();

        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String secondName = etSecondName.getText().toString();
        String salary = etSalary.getText().toString();
        String tubNum = etTubNum.getText().toString();
        String address = etAddress.getText().toString();
        String phone = etPhone.getText().toString();
        String position = etPosition.getText().toString();
        String birthDate = etBirthDate.getText().toString();
        String workDate = etWorkDate.getText().toString();
        String id = etID.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnAdd:
                Log.d(LOG_TAG, "--- Insert in Employee: ---");

                cv.put("name", name);
                cv.put("surname", surname);
                cv.put("secondName", secondName);
                cv.put("salary", salary);
                cv.put("tubNum", tubNum);
                cv.put("address", address);
                cv.put("phone", phone);
                cv.put("position", position);
                cv.put("birthDate", birthDate);
                cv.put("workDate", workDate);
                // вставляем запись и получаем ее ID
                long rowID = db.insert("employee", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
            case R.id.btnRead:
                Log.d(LOG_TAG, "--- Rows in Employee: ---");
                Cursor c = db.query("employee", null, null, null, null, null, null);

                if (c.moveToFirst()) {

                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int surnameColIndex = c.getColumnIndex("surname");
                    int secondNameColIndex = c.getColumnIndex("secondName");
                    int salaryColIndex = c.getColumnIndex("salary");
                    int positionColIndex = c.getColumnIndex("position");
                    int phoneColIndex = c.getColumnIndex("phone");
                    int addressColIndex = c.getColumnIndex("address");
                    int birthDateColIndex = c.getColumnIndex("birthDate");
                    int workDateColIndex = c.getColumnIndex("workDate");
                    int tubNumColIndex = c.getColumnIndex("tubNum");


                    do {
                        Log.d(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) + ", name = "
                                        + c.getString(nameColIndex) + ", surname = "
                                        + c.getString(surnameColIndex) + ", secondName = "
                                        + c.getString(secondNameColIndex) + ", salary = "
                                        + c.getInt(salaryColIndex) + ", position = "
                                        + c.getString(positionColIndex) + ", phone = "
                                        + c.getInt(phoneColIndex) + ", address = "
                                        + c.getString(addressColIndex) + ", birthDate = "
                                        + c.getString(birthDateColIndex) + ", workDate = "
                                        + c.getString(workDateColIndex) + ", tubNum = "
                                        + c.getInt(tubNumColIndex));
                    } while (c.moveToNext());
                } else
                    Log.d(LOG_TAG, "0 rows");
                c.close();
                break;
            case R.id.btnClear:
                Log.d(LOG_TAG, "--- Clear Employee: ---");
                int clearCount = db.delete("employee", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
            case R.id.btnUpd:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(LOG_TAG, "--- Update Employee: ---");
                cv.put("name", name);
                cv.put("surname", surname);
                cv.put("secondName", secondName);
                cv.put("salary", salary);
                cv.put("tubNum", tubNum);
                cv.put("address", address);
                cv.put("phone", phone);
                cv.put("position", position);
                cv.put("birthDate", birthDate);
                cv.put("workDate", workDate);
                // обновляем по id
                int updCount = db.update("employee", cv, "id = ?",
                        new String[] { id });
                Log.d(LOG_TAG, "updated rows count = " + updCount);
                break;
            case R.id.btnDel:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(LOG_TAG, "--- Delete from Employee: ---");
                // удаляем по id
                int delCount = db.delete("employee", "id = " + id, null);
                Log.d(LOG_TAG, "deleted rows count = " + delCount);
                break;
        }
        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "Lab5", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            db.execSQL("create table employee ("
                    + "id integer primary key autoincrement,"
                    + "tubNum integer,"
                    + "name text,"
                    + "salary integer,"
                    + "surname text,"
                    + "secondName text,"
                    + "phone integer,"
                    + "position text,"
                    + "address text,"
                    + "birthDate text,"
                    + "workDate text" + ");");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(LOG_TAG, " --- onUpgrade database from " + oldVersion
                    + " to " + newVersion + " version --- ");

            if (oldVersion == 1 && newVersion == 2) {

                ContentValues cv = new ContentValues();

                String[] name = new String[10];
                String[] surname  = new String[10];
                String[] secondName  = new String[10];
                String[] salary  = new String[10];
                String[] tubNum = new String[10];
                String[] address = new String[10];
                String[] phone = new String[10];
                String[] position = new String[10];
                String[] birthDate = new String[10];
                String[] workDate = new String[10];
                String[] id = new String[10];

                db.beginTransaction();
                try {
                    db.execSQL("drop table employee;");

                    db.execSQL("create table employee1 ("
                            + "id integer primary key autoincrement,"
                            + "tubNum integer,"
                            + "name text,"
                            + "salary integer,"
                            + "surname text,"
                            + "secondName text,"
                            + "phone integer,"
                            + "position text,"
                            + "address text,"
                            + "birthDate text,"
                            + "workDate text" + ");");

                    Cursor c = db.query("employee", null, null, null, null, null, null);
                    int i = 0;

                    if (c.moveToFirst()) {

                        int idColIndex = c.getColumnIndex("id");
                        int nameColIndex = c.getColumnIndex("name");
                        int surnameColIndex = c.getColumnIndex("surname");
                        int secondNameColIndex = c.getColumnIndex("secondName");
                        int salaryColIndex = c.getColumnIndex("salary");
                        int positionColIndex = c.getColumnIndex("position");
                        int phoneColIndex = c.getColumnIndex("phone");
                        int addressColIndex = c.getColumnIndex("address");
                        int birthDateColIndex = c.getColumnIndex("birthDate");
                        int workDateColIndex = c.getColumnIndex("workDate");
                        int tubNumColIndex = c.getColumnIndex("tubNum");

                        do {
                            id[i] = c.getString(idColIndex);
                            name[i] = c.getString(nameColIndex);
                            surname[i] = c.getString(surnameColIndex);
                            secondName[i] = c.getString(secondNameColIndex);
                            salary[i] = c.getString(salaryColIndex);
                            position[i] = c.getString(positionColIndex);
                            phone[i] = c.getString(phoneColIndex);
                            address[i] = c.getString(addressColIndex);
                            birthDate[i] = c.getString(birthDateColIndex);
                            workDate[i] = c.getString(workDateColIndex);
                            tubNum[i] = c.getString(tubNumColIndex);
                            i++;
                        } while (c.moveToNext());
                    }
                    c.close();

                    // заполняем ее
                    for (int j = 0 ; j < i ; j++) {

                        cv.put("name", name[i]);
                        cv.put("surname", surname[i]);
                        cv.put("secondName", secondName[i]);
                        cv.put("salary", salary[i]);
                        cv.put("tubNum", tubNum[i]);
                        cv.put("address", address[i]);
                        cv.put("phone", phone[i]);
                        cv.put("position", position[i]);
                        cv.put("birthDate", birthDate[i]);
                        cv.put("workDate", workDate[i]);
                    }

                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
            }
        }
    }
}


