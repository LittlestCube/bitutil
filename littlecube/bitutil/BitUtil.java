package littlecube.bitutil;

public abstract class BitUtil
{
	public static int bit(int position, int value)
	{
		return ((position & (0x1 << (value))) >> value) & 0x1;
	}
	
	public static short bit(short position, int value)
	{
		return (short) bit((int) position, value);
	}
	
	public static byte bit(byte position, int value)
	{
		return (byte) bit((int) position, value);
	}
	
	
	
	public static int craftBitInt(int moveTo)
	{
		return (1 << moveTo);
	}
	
	public static short craftBitShort(int moveTo)
	{
		return (short) craftBitInt(moveTo);
	}
	
	public static byte craftBitByte(int moveTo)
	{
		return (byte) craftBitInt(moveTo);
	}
	
	
	
	public static int subByte(int position, int value)
	{
		int selectedByte = (8 * value);
		
		return ((position & (0xFF << selectedByte))) >> selectedByte;
	}
	
	public static short subByte(short position, int value)
	{
		return (short) subByte((int) position, value);
	}
	
	
	
	public static int parity(int input)
	{
		int parity = 0;
		
		for (int i = 0; i < 32; i++)
		{
			parity ^= bit(input, i);
		}
		
		return parity;
	}
	
	public static short parity(short input)
	{
		return (short) parity((int) input & 0xFFFF);
	}
	
	public static byte parity(byte input)
	{
		return (byte) parity((int) input & 0xFF);
	}
}