package testInfo;

public class Main {
	public static void main(String []args)
	{
		if (args.length == 0)
		{
			args = new String[1];
			args[0] = "1";
		}
		else
			args[0] = Integer.toString(1+(Integer.parseInt(args[0])));
		System.out.printf("Stack no: %s\n", args[0]);
		main(args);
	}
}
