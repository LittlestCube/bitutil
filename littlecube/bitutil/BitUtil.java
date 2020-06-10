package littlecube.bitutil;

public abstract class BitUtil
{
	public static int bit(int input, int bitnum)
	{
		return (input & (0x80 >> (7 - bitnum))) >> bitnum;
	}
	
	public static short bit(short input, int bitnum)
	{
		return (short) bit((int) input, bitnum);
	}
	
	public static byte bit(byte input, int bitnum)
	{
		return (byte) bit((int) input, bitnum);
	}
	
	public static int craftBit(int input, int bitToMove, int moveTo)
	{
		return (bit(input, bitToMove) << moveTo);
	}
	
	public static short craftBit(short input, int bitToMove, int moveTo)
	{
		return (short) craftBit((int) input, bitToMove, moveTo);
	}
	
	public static byte craftBit(byte input, int bitToMove, int moveTo)
	{
		return (byte) craftBit((int) input, bitToMove, moveTo);
	}
	
	public static int subByte(int input, int bitnum)
	{
		int selectedByte = (8 * bitnum);
		
		return ((input & (0xFF << selectedByte))) >> selectedByte;
	}
	
	public static short subByte(short input, int bitnum)
	{
		return (short) subByte((int) input, bitnum);
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