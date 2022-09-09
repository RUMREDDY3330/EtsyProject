package StepDefinations;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		 Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("ddMMhhmm");
	      String dat = ft.format(dNow).toString();
	      System.out.println(dat);

	}

}
