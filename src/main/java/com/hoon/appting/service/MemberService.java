package com.hoon.appting.service;

import com.hoon.appting.dto.ApiDataModel;
import com.hoon.appting.dto.MemberDto;
import com.hoon.appting.repository.entity.Member;
import com.hoon.appting.repository.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoon on 2015-04-26.
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void addMember(MemberDto memberDto) {
        Member member = new Member();
        convertMemberDtoToMember(memberDto, member);
        memberRepository.save(member);
    }

    private void convertMemberDtoToMember(MemberDto memberDto, Member member) {
        member.setMail(memberDto.getMail());
        member.setPassword(memberDto.getPassword());
        member.setName(memberDto.getName());
        member.setSex(memberDto.getSex());
        member.setPhone(memberDto.getPhone());
        member.setBirthday(memberDto.getBirthday());
        member.setDeviceRegId(memberDto.getDeviceRegId());
        member.setPhoneAuth(memberDto.getPhoneAuth());
        member.setAge(memberDto.getAge());
        member.setKakaoId(memberDto.getKakaoId());
        member.setAddress1(memberDto.getAddress1());
        member.setAddress2(memberDto.getAddress2());
        member.setCreateAt(memberDto.getCreateAt());
        member.setUpdateAt(memberDto.getUpdateAt());

        member.setNickName(memberDto.getNickName());
        member.setJob(memberDto.getJob());
        member.setReligion(memberDto.getReligion());
        member.setBloodType(memberDto.getBloodType());
        member.setSelfIntroduction(memberDto.getSelfIntroduction());
        member.setHobby(memberDto.getHobby());
        member.setIdealType(memberDto.getIdealType());
        member.setMyAppeal(memberDto.getMyAppeal());

        member.setImage1(memberDto.getImage1());
        member.setImage2(memberDto.getImage2());
        member.setImage3(memberDto.getImage3());
        member.setImage4(memberDto.getImage4());
    }

    /**
     * 메일로 멤버 찾기
     * @param mail
     * @return
     */
    public MemberDto findMember(String mail) {
        Member member = memberRepository.findByMail(mail);
        MemberDto memberDto = new MemberDto();

        if (member == null) {
            return null;
        }

        convertMemberToMemberDto(member, memberDto);
        return memberDto;
    }

    public ApiDataModel<MemberDto> getMemberAtApi(String mail) {
        ApiDataModel<MemberDto> apiDataModel = new ApiDataModel<MemberDto>();
        MemberDto memberDto = findMember(mail);
        if (memberDto == null) {
            apiDataModel.setApiSuccess(false);
            apiDataModel.setApiMessage("등록된회원이 아닙니다.");
            return apiDataModel;
        }
        if ("null".equals(memberDto.getPhone())) {
            System.out.println("null string");
        }
        System.out.println("getPhone [" + memberDto.getPhone() + "]");
        System.out.println("getSelfIntroduction : " + memberDto.getSelfIntroduction());
        System.out.println("getIdealType : " + memberDto.getIdealType());
        System.out.println("getMyAppeal : " + memberDto.getMyAppeal());
        apiDataModel.setDto(memberDto);
        return apiDataModel;
    }

    public List<MemberDto> getAllMembers() {
        List<MemberDto> list = new ArrayList<MemberDto>();
        List<Member> memberList = memberRepository.findAll();
        for (Member member : memberList) {
            MemberDto memberDto = new MemberDto();
            convertMemberToMemberDto(member, memberDto);
            list.add(memberDto);
        }
        return list;
    }

    private void convertMemberToMemberDto(Member member, MemberDto memberDto) {
        memberDto.setMail(member.getMail());
        memberDto.setPassword(member.getPassword());
        memberDto.setName(member.getName());
        memberDto.setSex(member.getSex());
        memberDto.setPhone(member.getPhone());
        memberDto.setBirthday(member.getBirthday());
        memberDto.setDeviceRegId(member.getDeviceRegId());
        memberDto.setPhoneAuth(member.getPhoneAuth());
        memberDto.setAge(member.getAge());
        memberDto.setKakaoId(member.getKakaoId());
        memberDto.setAddress1(member.getAddress1());
        memberDto.setAddress2(member.getAddress2());
        memberDto.setCreateAt(member.getCreateAt());
        memberDto.setUpdateAt(member.getUpdateAt());

        memberDto.setNickName(member.getNickName());
        memberDto.setJob(member.getJob());
        memberDto.setReligion(member.getReligion());
        memberDto.setBloodType(member.getBloodType());
        memberDto.setSelfIntroduction(member.getSelfIntroduction());
        memberDto.setHobby(member.getHobby());
        memberDto.setIdealType(member.getIdealType());
        memberDto.setMyAppeal(member.getMyAppeal());

        memberDto.setImage1(member.getImage1());
        memberDto.setImage2(member.getImage2());
        memberDto.setImage3(member.getImage3());
        memberDto.setImage4(member.getImage4());

    }

    public MemberDto updateMember(MemberDto memberDto) {
        System.out.println("메일 : " + memberDto.getMail());
        Member member = memberRepository.findByMail(memberDto.getMail());
        member.setName(memberDto.getName());
        member.setBirthday(memberDto.getBirthday());
        member.setSex(memberDto.getSex());
        member.setPhone(memberDto.getPhone());
        member.setPhoneAuth(memberDto.getPhoneAuth());

        memberRepository.save(member);
        return memberDto;
    }

    public MemberDto updateMemberBasicProfile(MemberDto memberDto) {
        System.out.println("메일 : " + memberDto.getMail());
        Member member = memberRepository.findByMail(memberDto.getMail());
        member.setNickName(memberDto.getNickName());
        member.setAddress1(memberDto.getAddress1());
        member.setBloodType(memberDto.getBloodType());
        member.setReligion(memberDto.getReligion());
        member.setJob(memberDto.getJob());

        memberRepository.save(member);
        return memberDto;
    }

    public MemberDto updateMemberIntroduction(MemberDto memberDto) {
        System.out.println("메일 : " + memberDto.getMail());
        Member member = memberRepository.findByMail(memberDto.getMail());
        member.setSelfIntroduction(memberDto.getSelfIntroduction());
        member.setHobby(memberDto.getHobby());
        member.setMyAppeal(memberDto.getMyAppeal());
        member.setIdealType(memberDto.getIdealType());

        memberRepository.save(member);
        return memberDto;
    }

    public MemberDto updateMemberProfileImage(MemberDto memberDto, String imageNumber) {
        System.out.println("메일 : " + memberDto.getMail());
        Member member = memberRepository.findByMail(memberDto.getMail());

        if (imageNumber.equals("1")) {
            member.setImage1(memberDto.getImage1());
        } else if (imageNumber.equals("2")) {
            member.setImage2(memberDto.getImage2());
        } else if (imageNumber.equals("3")) {
            member.setImage3(memberDto.getImage3());
        } else if (imageNumber.equals("4")) {
            member.setImage4(memberDto.getImage4());
        }

        memberRepository.save(member);
        return memberDto;
    }
}
