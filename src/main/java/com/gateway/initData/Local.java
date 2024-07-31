package com.gateway.initData;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gateway.constant.BaseEndpoint;
import com.gateway.initData.dto.PersonSignSaveDTO;
import com.gateway.initData.model.Element;
import com.gateway.initData.model.ElementTrait;
import com.gateway.initData.model.Person;
import com.gateway.initData.model.PersonNote;
import com.gateway.initData.model.PersonTag;
import com.gateway.initData.model.PersonTagCross;
import com.gateway.initData.model.Sign;
import com.gateway.initData.repository.ElementRepository;
import com.gateway.initData.repository.ElementTraitRepository;
import com.gateway.initData.repository.PersonNoteRepository;
import com.gateway.initData.repository.PersonTagCrossRepository;
import com.gateway.initData.repository.PersonTagRepository;
import com.gateway.initData.repository.SignRepository;


@Component
public class Local {
	
	@Value("${env.profile.ip}")
	private String profileIp;
	@Value("${env.zodiacsign.ip}")
	private String zodiacsignIp;
	@Value("${env.gateway.ip}")
	private String gatewayIp;
	
	@Autowired
	private PersonNoteRepository personNoteRepository;
	
	@Autowired
	private ElementRepository elementRepository;
	
	@Autowired
	private SignRepository signRepository;
	
	@Autowired
	private ElementTraitRepository elementTraitRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PersonTagRepository personTagRepository;
	
	@Autowired
	private PersonTagCrossRepository personTagCrossRepository;
	
	@Profile("prod")
	@Bean
	private void initProd() throws Exception {
		BaseEndpoint.Profile.IP = profileIp;
		BaseEndpoint.Profile.BASE_ENDPOINT = BaseEndpoint.Profile.TP + "://" + BaseEndpoint.Profile.IP + ":" + BaseEndpoint.Profile.PORT + BaseEndpoint.Profile.PATH;
		BaseEndpoint.ZodiacSign.IP = zodiacsignIp;
		BaseEndpoint.ZodiacSign.BASE_ENDPOINT = BaseEndpoint.ZodiacSign.TP + "://" + BaseEndpoint.ZodiacSign.IP + ":" + BaseEndpoint.ZodiacSign.PORT + BaseEndpoint.ZodiacSign.PATH;
		BaseEndpoint.Gateway.IP = gatewayIp;
		BaseEndpoint.Gateway.BASE_ENDPOINT = BaseEndpoint.Gateway.TP + "://" + BaseEndpoint.Gateway.IP + ":" + BaseEndpoint.Gateway.PORT + BaseEndpoint.Gateway.PATH;
		insertDB();
	}
	
	@Profile("local")
	@Bean
	private void initLocal() throws Exception {
		insertDB();
	}
	
	private void insertDB() {
		Element waterElement = Element.builder()
				.elementName("水象")
				.mentalImage("各種水，建築物感性話")
				.build();
		elementRepository.save(waterElement);
		Element earthElement = Element.builder()
				.elementName("土象")
				.mentalImage("建築物")
				.build();
		elementRepository.save(earthElement);
		Element airElement = Element.builder()
				.elementName("風象")
				.mentalImage("程式")
				.build();
		elementRepository.save(airElement);
		Element fireElement = Element.builder()
				.elementName("火象")
				.mentalImage("kpi,api")
				.build();
		elementRepository.save(fireElement);
		
		// ===========================================
		
		ElementTrait elementTrait01 = ElementTrait.builder()
				.content("有原則，但是原則外的就很隨和(看其他星座)")
				.elementId(earthElement.getElementId())
				.build();
		elementTraitRepository.save(elementTrait01);
		
		ElementTrait elementTrait03 = ElementTrait.builder()
				.content("水象的特徵01")
				.elementId(waterElement.getElementId())
				.build();
		elementTraitRepository.save(elementTrait03);
		
		ElementTrait elementTrait04 = ElementTrait.builder()
				.content("水象的特徵02")
				.elementId(waterElement.getElementId())
				.build();
		elementTraitRepository.save(elementTrait04);
		
		ElementTrait elementTrait05 = ElementTrait.builder()
				.content("水象的特徵03")
				.elementId(waterElement.getElementId())
				.build();
		elementTraitRepository.save(elementTrait05);
		
		ElementTrait elementTrait06 = ElementTrait.builder()
				.content("風象的特徵01")
				.elementId(airElement.getElementId())
				.build();
		elementTraitRepository.save(elementTrait06);
		
		// ===========================================
		
		Sign capricorn = Sign.builder()
				.signName("摩羯座")
				.startDate(LocalDate.of(1999, 12, 22)) 
				.middleDate(LocalDate.of(2000, 1, 5))
				.endDate(LocalDate.of(2000, 1, 20))
				.serialNumber(1)
				.element(earthElement)
				.elementId(earthElement.getElementId())
				.build();
		signRepository.save(capricorn);
		Sign aquarius = Sign.builder()
				.signName("水瓶座")
				.startDate(LocalDate.of(2000, 1, 21))
				.middleDate(LocalDate.of(2000, 2, 3))
				.endDate(LocalDate.of(2000, 2, 18))
				.serialNumber(2)
				.element(airElement)
				.elementId(airElement.getElementId())
				.build();
		signRepository.save(aquarius);
		Sign pisces = Sign.builder()
				.signName("雙魚座")
				.startDate(LocalDate.of(2000, 2, 19))
				.middleDate(LocalDate.of(2000, 3, 4))
				.endDate(LocalDate.of(2000, 3, 20))
				.serialNumber(3)
				.element(waterElement)
				.elementId(waterElement.getElementId())
				.build();
		signRepository.save(pisces);
		Sign aries = Sign.builder()
				.signName("牡羊座")
				.startDate(LocalDate.of(2000, 3, 21))
				.middleDate(LocalDate.of(2000, 4, 3))
				.endDate(LocalDate.of(2000, 4, 19))
				.serialNumber(4)
				.element(fireElement)
				.elementId(fireElement.getElementId())
				.build();
		signRepository.save(aries);
		Sign taurus = Sign.builder()
				.signName("金牛座")
				.startDate(LocalDate.of(2000, 4, 20))
				.middleDate(LocalDate.of(2000, 5, 5))
				.endDate(LocalDate.of(2000, 5, 20))
				.serialNumber(5)
				.element(earthElement)
				.elementId(earthElement.getElementId())
				.build();
		signRepository.save(taurus);
		Sign gemini = Sign.builder()
				.signName("雙子座")
				.startDate(LocalDate.of(2000, 5, 21))
				.middleDate(LocalDate.of(2000, 6, 5))
				.endDate(LocalDate.of(2000, 6, 21))
				.serialNumber(6)
				.element(airElement)
				.elementId(airElement.getElementId())
				.build();
		signRepository.save(gemini);
		Sign cancer = Sign.builder()
				.signName("巨蟹座")
				.startDate(LocalDate.of(2000, 6, 22))
				.middleDate(LocalDate.of(2000, 7, 6))
				.endDate(LocalDate.of(2000, 7, 22))
				.serialNumber(7)
				.element(waterElement)
				.elementId(waterElement.getElementId())
				.build();
		signRepository.save(cancer);
		Sign leo = Sign.builder()
				.signName("獅子座")
				.startDate(LocalDate.of(2000, 7, 23))
				.middleDate(LocalDate.of(2000, 8, 6))
				.endDate(LocalDate.of(2000, 8, 22))
				.serialNumber(8)
				.element(fireElement)
				.elementId(fireElement.getElementId())
				.build();
		signRepository.save(leo);
		Sign virgo = Sign.builder()
				.signName("處女座")
				.startDate(LocalDate.of(2000, 8, 23))
				.middleDate(LocalDate.of(2000, 9, 6))
				.endDate(LocalDate.of(2000, 9, 22))
				.serialNumber(9)
				.element(earthElement)
				.elementId(earthElement.getElementId())
				.build();
		signRepository.save(virgo);
		Sign libra = Sign.builder()
				.signName("天秤座")
				.startDate(LocalDate.of(2000, 9, 23))
				.middleDate(LocalDate.of(2000, 10, 8))
				.endDate(LocalDate.of(2000, 10, 23))
				.serialNumber(10)
				.element(airElement)
				.elementId(airElement.getElementId())
				.build();
		signRepository.save(libra);
		Sign scorpio = Sign.builder()
				.signName("天蠍座")
				.startDate(LocalDate.of(2000, 10, 24))
				.middleDate(LocalDate.of(2000, 11, 7))
				.endDate(LocalDate.of(2000, 11, 22))
				.serialNumber(11)
				.element(waterElement)
				.elementId(waterElement.getElementId())
				.build();
		signRepository.save(scorpio);
		Sign sagittarius = Sign.builder()
				.signName("射手座")
				.startDate(LocalDate.of(2000, 11, 23))
				.middleDate(LocalDate.of(2000, 12, 7))
				.endDate(LocalDate.of(2000, 12, 21))
				.serialNumber(12)
				.element(fireElement)
				.elementId(fireElement.getElementId())
				.build();
		signRepository.save(sagittarius);
	
		// ===========================================
		PersonTag personTag01 = PersonTag.builder().content("香菜").build();
		personTagRepository.save(personTag01);
		PersonTag personTag02 = PersonTag.builder().content("程式").build();
		personTagRepository.save(personTag02);
		PersonTag personTag03 = PersonTag.builder().content("台中人").build();
		personTagRepository.save(personTag03);
		// ===========================================
		String savePersonUrl = BaseEndpoint.Profile.BASE_ENDPOINT + "/person";
		String savePersonSignUrl = BaseEndpoint.ZodiacSign.BASE_ENDPOINT + "/personSign";
		
		Person person01 = Person.builder().personName("柑仔").build();
		// save person
		String preson01Id = restTemplate.postForObject(savePersonUrl, person01, String.class);
		PersonSignSaveDTO personSignSaveDTO01 = PersonSignSaveDTO.builder().personId(preson01Id)
				.birthDay(LocalDate.of(1991, 01, 20))
				.sunId(null)
				.moonId(pisces.getSignId())
				.raiseId(aquarius.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO01, Object.class);
		// personNote
		PersonNote personNote011 = PersonNote.builder().personId(preson01Id).content("存錢存錢存錢").build();
		personNoteRepository.save(personNote011);
		// personTagCross
		PersonTagCross personTagCross011 = PersonTagCross.builder().personId(preson01Id).personTagId(personTag01.getPersonTagId()).range(-1).build();
		personTagCrossRepository.save(personTagCross011);
		PersonTagCross personTagCross012 = PersonTagCross.builder().personId(preson01Id).personTagId(personTag02.getPersonTagId()).range(2).build();
		personTagCrossRepository.save(personTagCross012);
		PersonTagCross personTagCross013 = PersonTagCross.builder().personId(preson01Id).personTagId(personTag03.getPersonTagId()).range(0).build();
		personTagCrossRepository.save(personTagCross013);
		
		Person person02 = Person.builder().personName("阿亮").build();
		// save person
		String preson02Id = restTemplate.postForObject(savePersonUrl, person02, String.class);
		PersonSignSaveDTO personSignSaveDTO02 = PersonSignSaveDTO.builder().personId(preson02Id)
				.birthDay(LocalDate.of(1992, 10, 10))
				.sunId(null)
				.moonId(leo.getSignId())
				.raiseId(cancer.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO02, Object.class);
		// personNote
		PersonNote personNote021 = PersonNote.builder().personId(preson02Id).content("8月去宜蘭宜蘭玩").build();
		personNoteRepository.save(personNote021);
		PersonNote personNote022 = PersonNote.builder().personId(preson02Id).content("9月要去哪裡玩").build();
		personNoteRepository.save(personNote022);
		PersonNote personNote023 = PersonNote.builder().personId(preson02Id).content("10月要去哪裡玩").build();
		personNoteRepository.save(personNote023);
		PersonNote personNote024 = PersonNote.builder().personId(preson02Id).content("11月要去哪裡玩").build();
		personNoteRepository.save(personNote024);
		PersonNote personNote025 = PersonNote.builder().personId(preson02Id).content("12月要去哪裡玩").build();
		personNoteRepository.save(personNote025);
		// personTagCross
		PersonTagCross personTagCross021 = PersonTagCross.builder().personId(preson02Id).personTagId(personTag01.getPersonTagId()).range(2).build();
		personTagCrossRepository.save(personTagCross021);
		PersonTagCross personTagCross022 = PersonTagCross.builder().personId(preson02Id).personTagId(personTag02.getPersonTagId()).range(0).build();
		personTagCrossRepository.save(personTagCross022);
		
		Person person03 = Person.builder().personName("大可").build();
		// save person
		String preson03Id = restTemplate.postForObject(savePersonUrl, person03, String.class);
		PersonSignSaveDTO personSignSaveDTO03 = PersonSignSaveDTO.builder().personId(preson03Id)
				.birthDay(null)
				.sunId(pisces.getSignId())
				.moonId(taurus.getSignId())
				.raiseId(pisces.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO03, Object.class);
		// personTagCross
		PersonTagCross personTagCross031 = PersonTagCross.builder().personId(preson03Id).personTagId(personTag03.getPersonTagId()).range(0).build();
		personTagCrossRepository.save(personTagCross031);

		Person person04 = Person.builder().personName("貝克").build();
		// save person
		String preson04Id = restTemplate.postForObject(savePersonUrl, person04, String.class);
		PersonSignSaveDTO personSignSaveDTO04 = PersonSignSaveDTO.builder().personId(preson04Id)
				.birthDay(null)
				.sunId(cancer.getSignId())
				.moonId(scorpio.getSignId())
				.raiseId(capricorn.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO04, Object.class);

		Person person05 = Person.builder().personName("小維").build();
		// save person
		String preson05Id = restTemplate.postForObject(savePersonUrl, person05, String.class);
		PersonSignSaveDTO personSignSaveDTO05 = PersonSignSaveDTO.builder().personId(preson05Id)
				.birthDay(LocalDate.of(2000, 7, 30))
				.sunId(leo.getSignId())
				.moonId(gemini.getSignId())
				.raiseId(virgo.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO05, Object.class);
		
		Person person06 = Person.builder().personName("肚肚").build();
		// save person
		String preson06Id = restTemplate.postForObject(savePersonUrl, person06, String.class);
		PersonSignSaveDTO personSignSaveDTO06 = PersonSignSaveDTO.builder().personId(preson06Id)
				.birthDay(LocalDate.of(2000, 8, 14))
				.sunId(leo.getSignId())
				.moonId(libra.getSignId())
				.raiseId(sagittarius.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO06, Object.class);

//		Person person07 = Person.builder().personName("匪肥").build();
//		// save person
//		String preson07Id = restTemplate.postForObject(savePersonUrl, person07, String.class);
//		PersonSignSaveDTO personSignSaveDTO07 = PersonSignSaveDTO.builder().personId(preson07Id)
//				.birthDay(null)
//				.sunId(capricorn.getSignId())
//				.moonId(aquarius.getSignId())
//				.raiseId(sagittarius.getSignId())
//				.build();
//		// save personSign
//		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO07, Object.class);		

		Person person08 = Person.builder().personName("蛋餅").build();
		// save person
		String preson08Id = restTemplate.postForObject(savePersonUrl, person08, String.class);
		PersonSignSaveDTO personSignSaveDTO08 = PersonSignSaveDTO.builder().personId(preson08Id)
				.birthDay(null)
				.sunId(virgo.getSignId())
				.moonId(taurus.getSignId())
				.raiseId(scorpio.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO08, Object.class);

		Person person09 = Person.builder().personName("芋頭").build();
		// save person
		String preson09Id = restTemplate.postForObject(savePersonUrl, person09, String.class);
		PersonSignSaveDTO personSignSaveDTO09 = PersonSignSaveDTO.builder().personId(preson09Id)
				.birthDay(null)
				.sunId(taurus.getSignId())
				.moonId(capricorn.getSignId())
				.raiseId(libra.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO09, Object.class);

		Person person10 = Person.builder().personName("湯姆").build();
		// save person
		String preson10Id = restTemplate.postForObject(savePersonUrl, person10, String.class);
		PersonSignSaveDTO personSignSaveDTO10 = PersonSignSaveDTO.builder().personId(preson10Id)
				.birthDay(null)
				.sunId(pisces.getSignId())
				.moonId(leo.getSignId())
				.raiseId(libra.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO10, Object.class);

		Person person11 = Person.builder().personName("小馬").build();
		// save person
		String preson11Id = restTemplate.postForObject(savePersonUrl, person11, String.class);
		PersonSignSaveDTO personSignSaveDTO11 = PersonSignSaveDTO.builder().personId(preson11Id)
				.birthDay(LocalDate.of(1990, 9, 21))
				.sunId(virgo.getSignId())
				.moonId(libra.getSignId())
				.raiseId(sagittarius.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO11, Object.class);

		Person person12 = Person.builder().personName("小柏").build();
		// save person
		String preson12Id = restTemplate.postForObject(savePersonUrl, person12, String.class);
		PersonSignSaveDTO personSignSaveDTO12 = PersonSignSaveDTO.builder().personId(preson12Id)
				.birthDay(LocalDate.of(2000, 3, 10))
				.sunId(pisces.getSignId())
				.moonId(aquarius.getSignId())
				.raiseId(cancer.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO12, Object.class);

		Person person13 = Person.builder().personName("小麥").build();
		// save person
		String preson13Id = restTemplate.postForObject(savePersonUrl, person13, String.class);
		PersonSignSaveDTO personSignSaveDTO13 = PersonSignSaveDTO.builder().personId(preson13Id)
				.birthDay(null)
				.sunId(gemini.getSignId())
				.moonId(gemini.getSignId())
				.raiseId(scorpio.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO13, Object.class);

		Person person14 = Person.builder().personName("皮蛋").build();
		// save person
		String preson14Id = restTemplate.postForObject(savePersonUrl, person14, String.class);
		PersonSignSaveDTO personSignSaveDTO14 = PersonSignSaveDTO.builder().personId(preson14Id)
				.birthDay(LocalDate.of(2000, 11, 14))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO14, Object.class);
		
//		Person person15 = Person.builder().personName("阿賢").build();
//		// save person
//		String preson15Id = restTemplate.postForObject(savePersonUrl, person15, String.class);
//		PersonSignSaveDTO personSignSaveDTO15 = PersonSignSaveDTO.builder().personId(preson15Id)
//				.birthDay(LocalDate.of(1992, 6, 19))
//				.moonId(aquarius.getSignId())
//				.raiseId(virgo.getSignId())
//				.build();
//		// save personSign
//		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO15, Object.class);
		
		Person person16 = Person.builder().personName("小恕").build();
		// save person
		String preson16Id = restTemplate.postForObject(savePersonUrl, person16, String.class);
		PersonSignSaveDTO personSignSaveDTO16 = PersonSignSaveDTO.builder().personId(preson16Id)
				.birthDay(LocalDate.of(2000, 3, 3))
				.moonId(aquarius.getSignId())
				.raiseId(aries.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO16, Object.class);

		Person person17 = Person.builder().personName("小傑").build();
		// save person
		String preson17Id = restTemplate.postForObject(savePersonUrl, person17, String.class);
		PersonSignSaveDTO personSignSaveDTO17 = PersonSignSaveDTO.builder().personId(preson17Id)
				.birthDay(LocalDate.of(2000, 4, 2))
				.moonId(scorpio.getSignId())
				.raiseId(aries.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO17, Object.class);
		
		Person person18 = Person.builder().personName("oscar").build();
		// save person
		String preson18Id = restTemplate.postForObject(savePersonUrl, person18, String.class);
		PersonSignSaveDTO personSignSaveDTO18 = PersonSignSaveDTO.builder().personId(preson18Id)
				.birthDay(LocalDate.of(2000, 2, 24))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO18, Object.class);
		
		Person person19 = Person.builder().personName("賴寶").build();
		// save person
		String preson19Id = restTemplate.postForObject(savePersonUrl, person19, String.class);
		PersonSignSaveDTO personSignSaveDTO19 = PersonSignSaveDTO.builder().personId(preson19Id)
				.birthDay(LocalDate.of(2000, 2, 23))
				.moonId(aquarius.getSignId())
				.raiseId(aries.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO19, Object.class);
		
		Person person20 = Person.builder().personName("max").build();
		// save person
		String preson20Id = restTemplate.postForObject(savePersonUrl, person20, String.class);
		PersonSignSaveDTO personSignSaveDTO20 = PersonSignSaveDTO.builder().personId(preson20Id)
				.birthDay(LocalDate.of(2000, 5, 30))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO20, Object.class);
		
		Person person21 = Person.builder().personName("小致").build();
		// save person
		String preson21Id = restTemplate.postForObject(savePersonUrl, person21, String.class);
		PersonSignSaveDTO personSignSaveDTO21 = PersonSignSaveDTO.builder().personId(preson21Id)
				.birthDay(LocalDate.of(2000, 9, 23))
				.moonId(pisces.getSignId())
				.raiseId(cancer.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO21, Object.class);
		
		Person person22 = Person.builder().personName("七步").build();
		// save person
		String preson22Id = restTemplate.postForObject(savePersonUrl, person22, String.class);
		PersonSignSaveDTO personSignSaveDTO22 = PersonSignSaveDTO.builder().personId(preson22Id)
				.birthDay(LocalDate.of(2000, 6, 10))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO22, Object.class);
		
		Person person23 = Person.builder().personName("佑佑").build();
		// save person
		String preson23Id = restTemplate.postForObject(savePersonUrl, person23, String.class);
		PersonSignSaveDTO personSignSaveDTO23 = PersonSignSaveDTO.builder().personId(preson23Id)
				.birthDay(LocalDate.of(2000, 4, 5))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO23, Object.class);
		
		Person person24 = Person.builder().personName("嚕嚕").build();
		// save person
		String preson24Id = restTemplate.postForObject(savePersonUrl, person24, String.class);
		PersonSignSaveDTO personSignSaveDTO24 = PersonSignSaveDTO.builder().personId(preson24Id)
				.birthDay(LocalDate.of(2000, 8, 15))
				.moonId(leo.getSignId())
				.raiseId(scorpio.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO24, Object.class);
		
		Person person25 = Person.builder().personName("小奕").build();
		// save person
		String preson25Id = restTemplate.postForObject(savePersonUrl, person25, String.class);
		PersonSignSaveDTO personSignSaveDTO25 = PersonSignSaveDTO.builder().personId(preson25Id)
				.birthDay(LocalDate.of(2000, 2, 25))
				.moonId(aquarius.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO25, Object.class);
		
		Person person26 = Person.builder().personName("北傑").build();
		// save person
		String preson26Id = restTemplate.postForObject(savePersonUrl, person26, String.class);
		PersonSignSaveDTO personSignSaveDTO26 = PersonSignSaveDTO.builder().personId(preson26Id)
				.birthDay(LocalDate.of(2000, 3, 13))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO26, Object.class);
		
		Person person27 = Person.builder().personName("易君").build();
		// save person
		String preson27Id = restTemplate.postForObject(savePersonUrl, person27, String.class);
		PersonSignSaveDTO personSignSaveDTO27 = PersonSignSaveDTO.builder().personId(preson27Id)
				.birthDay(LocalDate.of(2000, 2, 10))
				.moonId(pisces.getSignId())
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO27, Object.class);
		
		Person person28 = Person.builder().personName("緯兒").build();
		// save person
		String preson28Id = restTemplate.postForObject(savePersonUrl, person28, String.class);
		PersonSignSaveDTO personSignSaveDTO28 = PersonSignSaveDTO.builder().personId(preson28Id)
				.birthDay(LocalDate.of(2000, 8, 31))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO28, Object.class);
		
		Person person29 = Person.builder().personName("小逸").build();
		// save person
		String preson29Id = restTemplate.postForObject(savePersonUrl, person29, String.class);
		PersonSignSaveDTO personSignSaveDTO29 = PersonSignSaveDTO.builder().personId(preson29Id)
				.birthDay(LocalDate.of(2000, 1, 24))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO29, Object.class);
		
		Person person30 = Person.builder().personName("蟲蟲").build();
		// save person
		String preson30Id = restTemplate.postForObject(savePersonUrl, person30, String.class);
		PersonSignSaveDTO personSignSaveDTO30 = PersonSignSaveDTO.builder().personId(preson30Id)
				.birthDay(LocalDate.of(1991, 2, 2))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO30, Object.class);
		
		Person person31 = Person.builder().personName("晃晃").build();
		// save person
		String preson31Id = restTemplate.postForObject(savePersonUrl, person31, String.class);
		PersonSignSaveDTO personSignSaveDTO31 = PersonSignSaveDTO.builder().personId(preson31Id)
				.birthDay(LocalDate.of(1991, 8, 26))
				.build();
		// save personSign
		restTemplate.postForObject(savePersonSignUrl, personSignSaveDTO31, Object.class);
		// ===========================================
	}
}
