package littlecube.bitutil;

public abstract class BitUtil
{
	static int bit(int input, int bitnum)
	{
		return (input & (0x80 >> bitnum)) >> (7 - bitnum);
	}
	
	static short bit(short input, int bitnum)
	{
		return (short) bit((int) input, bitnum);
	}
	
	static byte bit(byte input, int bitnum)
	{
		return (byte) bit((int) input, bitnum);
	}
	
	static boolean parity(byte input)
	{
		boolean parity = false;
		
		for (int i = 0; i < 8; i++)
		{
			if (bit(input, i) == 1)
			{
				parity ^= true;
			}
		}
		
		return parity;
	}
}