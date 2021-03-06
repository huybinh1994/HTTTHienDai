package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import service.Sha256;
import model.MerchantInfo;
import model.MerchantsDTO;
import model.UserDTO;

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
			masterCode = generateCode("T", master_id, 4);
			agentCode = generateCode("A", agent_id, 6);
			subAgentCode = "S000000";
			merchantCode = "M0000000000";
		}
		else if(level == 3)
		{
			masterCode = generateCode("T", master_id, 4);
			agentCode = generateCode("A", agent_id, 6);
			subAgentCode = generateCode("S", sub_agent_id, 6);
			merchantCode = "M0000000000";
		}
		else
		{
			masterCode = generateCode("T", master_id, 4);
			agentCode = generateCode("A", agent_id, 6);
			subAgentCode = generateCode("S", sub_agent_id, 6);
			merchantCode = generateCode("M", merchant_id, 10);
		}
		
		return masterCode + agentCode + subAgentCode + merchantCode;
	}
	
	public static MerchantsDTO ConvertMerchantInfoToMerchantDTO(MerchantInfo info)
	{
		MerchantsDTO m = new MerchantsDTO();
		m.setMerchant_name(info.getMerchant_name());
		m.setMerchant_phone_call(info.getMerchant_phone_call());
		m.setAddress(info.getAddress());
		m.setProvince(info.getProvince());
		m.setDistrict(info.getDistrict());
		m.setWard(info.getWard());
		m.setMaster_id(info.getMaster_id());
		m.setAgent_id(info.getAgent_id());
		m.setSub_agent_id(info.getSub_agent_id());
		m.setLevel_id(info.getLevel_id());
		m.setType_id(info.getType_id());
		if(info.getActive() == 1)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date date = new Date();
			m.setFirst_active_date(dateFormat.format(date));
		}
		return m;
	}
	
	public static UserDTO ConvertMerchantInfoToUserDTO(MerchantInfo info)
	{
		UserDTO u = new UserDTO();
		u.setActive(info.getActive());
		u.setUsername(info.getUsername());
		u.setPassword(Sha256.convertSha256(info.getPassword()));
		u.setFlag(info.getLevel_id());
		return u;
	}
}
