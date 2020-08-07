import littlecube.bitutil.*;

public class Test
{
	public static void main(String args[])
	{
		System.out.println("Testing...");
		
		try
		{
			byte testbyte = 0x55;
			
			int bitbyte = BitUtil.craftByte(
			BitUtil.bit(7, testbyte),
			BitUtil.bit(6, testbyte),
			BitUtil.bit(5, testbyte),
			BitUtil.bit(4, testbyte),
			BitUtil.bit(3, testbyte),
			BitUtil.bit(2, testbyte),
			BitUtil.bit(1, testbyte),
			BitUtil.bit(0, testbyte));
			
			test("bit(int input, int bitnum)", 0x55, bitbyte);
			
			
			
			int bit1 = BitUtil.craftBitInt(1);
			int bit6 = BitUtil.craftBitInt(6);
			
			if (bit1 != 2)
			{
				test("craftBitInt(int moveTo)", 2, bit1);
			}
			
			if (bit6 != 64)
			{
				test("craftBitInt(int moveTo)", 64, bit6);
			}
			
			
			
			int subint = BitUtil.subByte(2, 0xDEADBEEF);
			short subshort = BitUtil.subByte(1, (short) 0xBEEF);
			
			test("subByte(int position, int val)", 0xAD, subint);
			
			test("subByte(int position, short val)", 0xBE, subshort);
			
			
			
			int pint = BitUtil.parity((int) 0x80FFFFFF);
			short pshort = BitUtil.parity((short) 0x07);
			byte pbyte = BitUtil.parity((byte) 0x00);
			
			test("parity(int input)", 1, pint);
			
			test("parity(short input)", 1, pshort);
			
			test("parity(byte input)", 0, pbyte);
			
			
			
			int bitSet = 0;
			
			bitSet = BitUtil.setBit(2, 1, bitSet);
			
			test("setBit(int position, int value, int destination)", 4, bitSet);
		}
		
		catch (Exception e)
		{
			System.err.println(e.toString());
			System.err.println("Your test boinked, dork! Fix your test, or fix your code.");
			System.exit(1);
		}
		
		System.out.println("All tests passed! Ready to push.");
	}
	
	static void test(String function, int expected, int testvalue) throws Exception
	{
		if (expected != testvalue)
		{
			throw new Exception(String.format("BitUtil.%s method failed! Result expected was 0x%08X, but test resulted in 0x%08X", function, expected, testvalue));
		}
	}
}