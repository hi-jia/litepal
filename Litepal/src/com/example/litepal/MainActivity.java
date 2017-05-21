package com.example.litepal;

import java.text.BreakIterator;
import java.util.List;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btnCreate:
			Connector.getDatabase();
			break;
		case R.id.btnAdd:
			Student s = new Student();
			s.setId(1);
			s.setAge(20);
			s.setName("xiaoming");
			Student ss = new Student();
			ss.setId(1);
			ss.setAge(20);
			ss.setName("aaaa");
			ss.save();
			break;
		case R.id.btnUpdate:
			Student s1 = new Student();
			s1.setId(10);
			s1.setAge(3);
			s1.updateAll("age=? and id=?","20","1");
			break;
		case R.id.btnDelete:
			DataSupport.deleteAll(Student.class, "age<?","20");
			break;
		case R.id.btnQuery:
			List<Student> list = DataSupport.findAll(Student.class);
			for (Student student:list) {
				Log.i("MainActivity", student.getName()+"");
				Log.i("MainActivity", student.getAge()+"");
				Log.i("MainActivity", student.getId()+"");
			}
			break;
		default:
			break;
		}

	}

}
