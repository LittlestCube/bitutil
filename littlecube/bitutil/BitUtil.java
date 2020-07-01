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
	
	
	
	public static int craftBitInt(int position)
	{
		return (1 << position);
	}
	
	public static short craftBitShort(int position)
	{
		return (short) craftBitInt(position);
	}
	
	public static byte craftBitByte(int position)
	{
		return (byte) craftBitInt(position);
	}
	
	public static byte craftByte(int bit7, int bit6, int bit5, int bit4, int bit3, int bit2, int bit1, int bit0)
	{
		return (byte) ((bit7 << 7) | (bit6 << 6) | (bit5 << 5) | (bit4 << 4) | (bit3 << 3) | (bit2 << 2) | (bit1 << 1) | (bit0));
	}
	
	public static short craftShort(int nbyte1, int nbyte0)
	{
		short s = 0;
		
		s = (short) setByte(0, nbyte0, s);
		s = (short) setByte(1, nbyte1, s);
		
		return s;
	}
	
	
	
	public static int setByte(int position, int nbyte, int val)
	{
		nbyte = nbyte & 0xFF;
		
		int actualPosition = position * 8;
		
		val = (short) ((nbyte << actualPosition) | (val & ~(0xFF << actualPosition)));
		
		return val;
	}
	
	public static int subByte(int position, int val)
	{
		int selectedByte = (8 * position);
		
		return ((val & (0xFF << selectedByte))) >> selectedByte;
	}
	
	public static short subByte(int position, short val)
	{
		return (short) subByte(position, (int) val);
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