package util;

public class UtilComponent {
	public static String leftPad(String originalString, int length, char padCharacter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(padCharacter);
		}
		String padding = sb.toString();
		String paddedString = padding.substring(originalString.length())
				+ originalString;
		return paddedString;
	}
	
	public static String generateCode(String prefix, int id, int lengthOfData)
	{
		String originalString = String.valueOf(id);
		String strId = leftPad(originalString, lengthOfData, '0');
		strId = prefix + strId;
		
		return strId;
	}
	
	public static String generateFullCode(int master_id, int agent_id, int sub_agent_id, int merchant_id, int level)
	{
		String masterCode = "";
		String agentCode = "";
		String subAgentCode = "";
		String merchantCode = "";
		//is agent
		if(level == 2)
		{
			masterCode = generateCode("T", master_id, 5);
			agentCode = generateCode("A", agent_id, 7);
			subAgentCode = "S000000";
			merchantCode = "M0000000000";
		}
		else if(level == 3)
		{
			masterCode = generateCode("T", master_id, 5);
			agentCode = generateCode("A", agent_id, 7);
			subAgentCode = generateCode("S", sub_agent_id, 7);
			merchantCode = "M0000000000";
		}
		else
		{
			masterCode = generateCode("T", master_id, 5);
			agentCode = generateCode("A", agent_id, 7);
			subAgentCode = generateCode("S", sub_agent_id, 7);
			merchantCode = generateCode("M", merchant_id, 11);
		}
		
		return masterCode + agentCode + subAgentCode + merchantCode;
	}
}
