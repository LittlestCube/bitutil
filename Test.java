import littlecube.bitutil.*;

public class Test
{
	public static void main(String args[])
	{
		System.out.println("Testing...");
		
		try
		{
			byte testbyte = 0x55;
			
			String bitbyte =
			Integer.toString(BitUtil.bit(7, testbyte)) +
			Integer.toString(BitUtil.bit(6, testbyte)) +
			Integer.toString(BitUtil.bit(5, testbyte)) +
			Integer.toString(BitUtil.bit(4, testbyte)) +
			Integer.toString(BitUtil.bit(3, testbyte)) +
			Integer.toString(BitUtil.bit(2, testbyte)) +
			Integer.toString(BitUtil.bit(1, testbyte)) +
			Integer.toString(BitUtil.bit(0, testbyte));
			
			if (!bitbyte.equals("01010101"))
			{
				test("bit(int input, int bitnum)", "01010101", bitbyte);
			}
			
			int bit1 = BitUtil.craftBitInt(1);
			int bit6 = BitUtil.craftBitInt(6);
			
			if (bit1 != 2)
			{
				test("craftBitInt(int moveTo)", "2", Integer.toString(bit1));
			}
			
			if (bit6 != 64)
			{
				test("craftBitInt(int moveTo)", "64", Integer.toString(bit6));
			}
			
			int subint = BitUtil.subByte(2, 0xDEADBEEF);
			short subshort = BitUtil.subByte(1, (short) 0xBEEF);
			
			if (subint != 0xAD)
			{
				test("subByte(int position, int val)", "0xAD", "0x" + Integer.toHexString(subint).toUpperCase());
			}
			
			if (subshort != 0xBE)
			{
				test("subByte(int position, short val)", "0xBE", "0x" + Integer.toHexString(subshort).toUpperCase());
			}
			
			int pint = BitUtil.parity((int) 0x80FFFFFF);
			short pshort = BitUtil.parity((short) 0x07);
			byte pbyte = BitUtil.parity((byte) 0x00);
			
			if (pint != 1)
			{
				test("parity(int input)", "1", Integer.toString(pint));
			}
			
			if (pshort != 1)
			{
				test("parity(short input)", "1", Integer.toString(pshort));
			}
			
			if (pbyte != 0)
			{
				test("parity(byte input)", "0", Integer.toString(pbyte));
			}
		}
		
		catch (Exception e)
		{
			System.err.println(e.toString());
			System.err.println("Your test boinked, dork! Fix your test, or fix your code.");
			System.exit(1);
		}
		
		System.out.println("All tests passed! Ready to push.");
	}
	
	static void test(String function, String expected, String testvalue) throws Exception
	{
		throw new Exception("BitUtil." + function + " function failed! Result expected was " + expected + ", but test resulted in " + testvalue);
	}
}