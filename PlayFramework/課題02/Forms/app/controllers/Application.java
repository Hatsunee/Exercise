package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import play.data.Form;
import static play.data.Form.*;

import java.util.Date;

public class Application extends Controller {

	//フォーム用の内部クラス
	public static class MyForm{
		public String name;
		public String password;
		public boolean check;
		public String radio;
		public String select;
		public String textarea;
		public Date date;
		public int num;
	}

    public static Result index() {
        Form<MyForm> myForm = form(MyForm.class).bindFromRequest();
        //myFormがエラーでないか判定
        if(!myForm.hasErrors()){
            String value = "フォームを入力して下さい";
            //初期値
            MyForm myForm_tmp = new MyForm();
            myForm_tmp.name = "default value";
            myForm_tmp.check = true;
            myForm_tmp.radio = "mac";
            myForm_tmp.select = "uk";
            myForm_tmp.num = 50;
            //初期値を格納
            myForm = myForm.fill(myForm_tmp);
            return ok(index.render(value,myForm));
        }else{
            return ok(index.render("エラーです。",new Form(MyForm.class)));
        }
    }


    public static Result send() {
		Form<MyForm> myForm = form(MyForm.class).bindFromRequest();
		//myFormがエラーでないか判定
        if(!myForm.hasErrors()){
        	MyForm data = myForm.get();
        	String value = "value: ";
        	value += "input = " + data.name + ", ";
        	value += "pass = " + data.password + ", ";
        	value += "check = " + data.check + ", ";
        	value += "radio = " + data.radio + ", ";
        	value += "select = " + data.select + ", ";
        	value += "area = " + data.textarea + ", ";
        	value += "date = " + data.date + ", ";
        	value += "num = " + data.num + ", ";        	        	      	        	    	        	      	
        	return ok(index.render(value,myForm));
        }else{
        	return ok(index.render("エラーです。",new Form(MyForm.class)));
        }
    }      

}
