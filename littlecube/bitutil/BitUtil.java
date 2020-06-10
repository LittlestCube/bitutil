package littlecube.bitutil;

public abstract class BitUtil
{
	public static int bit(int input, int bitnum)
	{
		return ((input & (0x1 << (bitnum))) >> bitnum) & 0x1;
	}
	
	public static short bit(short input, int bitnum)
	{
		return (short) bit((int) input, bitnum);
	}
	
	public static byte bit(byte input, int bitnum)
	{
		return (byte) bit((int) input, bitnum);
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
	
	public static int subByte(int input, int bytenum)
	{
		int selectedByte = (8 * bytenum);
		
		return ((input & (0xFF << selectedByte))) >> selectedByte;
	}
	
	public static short subByte(short input, int bytenum)
	{
		return (short) subByte((int) input, bytenum);
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