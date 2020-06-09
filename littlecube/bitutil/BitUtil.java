package littlecube.bitutil;

public abstract class BitUtil
{
	public static int bit(int input, int bitnum)
	{
		return (input & (0x80 >> bitnum)) >> (7 - bitnum);
	}
	
	public static short bit(short input, int bitnum)
	{
		return (short) bit((int) input, bitnum);
	}
	
	public static byte bit(byte input, int bitnum)
	{
		return (byte) bit((int) input, bitnum);
	}
	
	public static int parity(int input)
	{
		int parity = 0;
		
		for (int i = 0; i < 8; i++)
		{
			if (bit(input, i) == 1)
			{
				parity ^= 1;
			}
		}
		
		return parity;
	}
	
	public static short parity(short input)
	{
		return (short) parity((int) input);
	}
	
	public static byte parity(byte input)
	{
		return (byte) parity((int) input);
	}
}