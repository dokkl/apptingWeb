package com.hoon.appting.controller;

import com.hoon.appting.dto.ApiDataModel;
import com.hoon.appting.dto.MemberDto;
import com.hoon.appting.service.MemberService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.codehaus.jackson.map.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by hoon on 2015-04-26.
 */
@Controller
@RequestMapping(value = "members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /*@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public MemberDto createMember(@ModelAttribute("memberDto") MemberDto memberDto) {
        System.out.println("전화번호 : " + memberDto.getPhone());
        memberService.addMember(memberDto);
        MemberDto newMemberDto = memberService.getMember(memberDto.getMemberId());
        return newMemberDto;
    }*/

    @RequestMapping(value = "/createMemberView")
    public String createMemberView() {
        return "/createMemberView";
    }

    /*@RequestMapping(value = "/{memberId}")
    @ResponseBody
    public ApiDataModel<MemberDto> getMember(@PathVariable("memberId") String memberId) {

        return  memberService.getMemberAtApi(memberId);
    }*/

    @RequestMapping(value = "/findMember", method = RequestMethod.POST)
    @ResponseBody
    public ApiDataModel<MemberDto> findMember(@RequestBody String json) throws org.json.simple.parser.ParseException {
        System.out.println("findMember json :" + json);
        JSONObject jsonObj = (JSONObject)new JSONParser().parse(json);
        String mail = (String)jsonObj.get("mail");
        System.out.println("findMember mail :" + mail);
        return  memberService.getMemberAtApi(mail);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<MemberDto> getAllMembers() {
        return memberService.getAllMembers();
    }

    /*@ResponseStatus(HttpStatus.OK)
     @ResponseBody
     @RequestMapping(value = "/{memberId}", method = RequestMethod.PUT)
     public MemberDto updateMember(@PathVariable("memberId") String memberId, @RequestBody MemberDto memberDto) {
        return memberService.updateMember(memberId, memberDto);

    }*/

    /*@ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/{memberId}", method = RequestMethod.PUT)
    public MemberDto updateMember(@PathVariable("memberId") String memberId, @RequestBody String regIdJson) throws org.json.simple.parser.ParseException {
        JSONObject json = (JSONObject)new JSONParser().parse(regIdJson);
        String regId = (String)json.get("regId");

        MemberDto memberDto = new MemberDto();
        memberDto.setDeviceRegId(regId);
        return memberService.updateMember(memberId, memberDto);

    }*/

    @ResponseStatus(HttpStatus.OK)
     @ResponseBody
     @RequestMapping(value = "/{memberId}", method = RequestMethod.PUT)
     public ApiDataModel<MemberDto> updateMember(@PathVariable("memberId") String memberId, @RequestBody String memberJson) throws Exception {
        System.out.println("memberId :" + memberId);
        System.out.println("memberJson :" + memberJson);
        ObjectMapper mapper = new ObjectMapper();
        MemberDto memberDto = mapper.readValue(memberJson, MemberDto.class);
        System.out.println("memberDto :" + memberDto.getName());

        memberService.updateMember(memberDto);
        return returnApiData(memberDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/basicProfile/{memberId}", method = RequestMethod.PUT)
    public ApiDataModel<MemberDto> updateMemberBasicProfile(@PathVariable("memberId") String memberId, @RequestBody String memberJson) throws Exception {
        System.out.println("memberId :" + memberId);
        System.out.println("memberJson :" + memberJson);
        ObjectMapper mapper = new ObjectMapper();
        MemberDto memberDto = mapper.readValue(memberJson, MemberDto.class);
        System.out.println("memberDto nickName :" + memberDto.getNickName());

        memberService.updateMemberBasicProfile(memberDto);
        return returnApiData(memberDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/introduction/{memberId}", method = RequestMethod.PUT)
    public ApiDataModel<MemberDto> updateMemberIntroduction(@PathVariable("memberId") String memberId, @RequestBody String memberJson) throws Exception {
        System.out.println("memberId :" + memberId);
        System.out.println("memberJson :" + memberJson);
        ObjectMapper mapper = new ObjectMapper();
        MemberDto memberDto = mapper.readValue(memberJson, MemberDto.class);
        System.out.println("memberDto introduction :" + memberDto.getSelfIntroduction());

        memberService.updateMemberIntroduction(memberDto);
        return returnApiData(memberDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ApiDataModel<MemberDto> createMember(@RequestBody String memberJson) throws Exception {
        System.out.println("memberJson :" + memberJson);
        ObjectMapper mapper = new ObjectMapper();
        MemberDto memberDto = mapper.readValue(memberJson, MemberDto.class);
        System.out.println("memberDto :" + memberDto);

        memberService.addMember(memberDto);
        return returnApiData(memberDto);
    }

    private ApiDataModel<MemberDto> returnApiData(MemberDto memberDto) {
        ApiDataModel<MemberDto> apiDataModel = new ApiDataModel<MemberDto>();
        apiDataModel.setDto(memberDto);
        apiDataModel.setApiSuccess(true);
        return apiDataModel;
    }

    @RequestMapping(value = "/image/upload", method = RequestMethod.POST)
    @ResponseBody
    public String imageUpload(@RequestPart("file") MultipartFile imageFile, @RequestParam("mail") String mail, @RequestParam("imageNumber") String imageNumber) throws IOException {
        System.out.println("imageFile : " + imageFile.getName() + ":" + imageFile.getBytes());
        System.out.println("imageFile : " + imageFile.getContentType() + ":" + imageFile.getSize());
        System.out.println("mail :" + mail);
        System.out.println("imageNumber :" + imageNumber);

        if (mail == null || mail.equals("")) {  // for test
            mail = "papa@daum.net";
        }
        File file = new File("C:/temp/" + createFileName(mail));
        System.out.println("file.getAbsolutePath() :" + file.getAbsolutePath());
        Path path = Paths.get(file.getAbsolutePath());
        writeFile(imageFile.getBytes(), file);
        imageInfoUpdateToDb(mail, path.getFileName().toString(), imageNumber);
        return null;
    }

    private String createFileName(String mail) {
        if (mail == null) {
            return "null.jpg";
        }
        String id = mail.split("@")[0];
        String fileName = id + "_" + System.currentTimeMillis() + ".jpg";
        return fileName;
    }

    private void writeFile(byte[] data, File file) throws IOException{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(data);
        bos.flush();
        bos.close();
    }

    private void imageInfoUpdateToDb(String mail, String fileName, String imageNumber) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMail(mail);

        if (imageNumber.equals("1")) {
            memberDto.setImage1(fileName);
        } else if (imageNumber.equals("2")) {
            memberDto.setImage2(fileName);
        } else if (imageNumber.equals("3")) {
            memberDto.setImage3(fileName);
        } else if (imageNumber.equals("4")) {
            memberDto.setImage4(fileName);
        }
        memberService.updateMemberProfileImage(memberDto, imageNumber);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllMembersForWeb() {
        System.out.println("getAllMembersForWeb");
        ModelAndView mv = new ModelAndView("tables");
        List<MemberDto> memberList = memberService.getAllMembers();
        System.out.println("memberList size : " + memberList.size());
        mv.addObject("list", memberList);
        return mv;
    }
}
