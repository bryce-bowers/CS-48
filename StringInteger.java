
public class StringInteger{
    String s;
    int i;

    public String getString(){ return s; }
    public void setString(String str){ s = str; }
	
    public int getI(){ return i; }
    public void setI(int num){ i = num; }

    StringInteger(String str, int num)
    {
	setString(str);
	setI(num);
    }
}
