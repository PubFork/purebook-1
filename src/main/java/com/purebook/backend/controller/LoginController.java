package com.purebook.backend.controller;

import net.sf.json.JSONObject;
import com.purebook.backend.util.AesCbcUtil;
import com.purebook.backend.util.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.result.JsonResultwithData;
import com.example.result.ResultCode;
import com.purebook.backend.entity.User;
import com.purebook.backend.service.UserService;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="v1/login")
public class LoginController {

	@Autowired
	UserService userService;

	//登陆。
//	@RequestMapping(method=RequestMethod.GET)
//	public JsonResultwithData login(@RequestParam int id,@RequestParam String password){
//		User user=userService.findUserById(id);
//		if(user!=null){
//			if(user.getPassword().equals(password)){
//				JsonResultwithData jsonResultwithData=new JsonResultwithData();
//				jsonResultwithData.setData(user);
//				return jsonResultwithData;
//			}
//			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.NOT_LOGIN);
//			jsonResultwithData.setData(null);
//			return jsonResultwithData;
//		}
//		JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.NOT_FOUND);
//		jsonResultwithData.setData(null);
//		return jsonResultwithData;
//	}

	/**
	 * 解密用户敏感数据
	 *
	 * @param encryptedData 明文,加密数据
	 * @param iv            加密算法的初始向量
	 * @param code          用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid 和 session_key
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/decodeUserInfo", method = RequestMethod.POST)
//    public Map decodeUserInfo(String encryptedData, String iv, String code) {
	public Map decodeUserInfo(@RequestBody Map<String, String> request) {
        System.out.print(request.get("encryptedData") + ":" + request.get("iv") + ":" + request.get("code"));
		Map map = new HashMap();

		//登录凭证不能为空
		if (request.get("code") == null || request.get("code").length() == 0) {
			map.put("status", 0);
			map.put("msg", "code 不能为空");
			return map;
		}




		//////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
		//请求参数
		String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + request.get("code") + "&grant_type=" + grant_type;
		//发送请求
		String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
		//解析相应内容（转换成json对象）
		JSONObject json = JSONObject.fromObject(sr);
		//获取会话密钥（session_key）
		String session_key = json.get("session_key").toString();
		//用户的唯一标识（openid）
		String openid = (String) json.get("openid");



        User user = new User(openid, new Timestamp(System.currentTimeMillis()));
		user.setName(request.get("userName"));
		user.setAvatar(request.get("userAvatar"));
        userService.addUser(user);
        System.out.print(user.getName());


		//////////////// 2、对encryptedData加密数据进行AES解密 ////////////////

		try {
            System.out.print(request.get("encryptedData") + "\n" + request.get("iv") + "\n" + request.get("code") + "\n");

            String result = AesCbcUtil.decrypt(request.get("encryptedData"), session_key, request.get("iv"), "UTF-8");
			//System.out.print(result+ "is");

			if (null != result && result.length() > 0) {
				map.put("status", 1);
				map.put("msg", "解密成功");

				JSONObject userInfoJSON = JSONObject.fromObject(result);
				Map userInfo = new HashMap();
				userInfo.put("openId", userInfoJSON.get("openId"));
				userInfo.put("nickName", userInfoJSON.get("nickName"));
				userInfo.put("gender", userInfoJSON.get("gender"));
				userInfo.put("city", userInfoJSON.get("city"));
				userInfo.put("province", userInfoJSON.get("province"));
				userInfo.put("country", userInfoJSON.get("country"));
				userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
				userInfo.put("unionId", userInfoJSON.get("unionId"));
				map.put("userInfo", userInfo);
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
	}

}
