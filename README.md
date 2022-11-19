# Android Study 8주차 목표
made by [bmsk](https://github.com/YiBeomSeok)

## git
각 팀원들은 정해진 branch를 자신의 local 저장소에 clone 혹은 pull하여 구현한다.

## branch name 목록
- main
- develop
- feature/1-main-activity
- feature/2-maddy-fragment
- feature/3-wbham-fragment
- feature/4-Jaeeepp-fragment
- feature/5-Arr-fragment
- feature/6-RDH-fragment

## main branch
main branch는 절대 직접 수정하지 않는다. develop branch에서의 모든 작업이 끝났을 때 pull request를 통해 수정된다.

## develop branch
develop branch는 절대 직접 수정하지 않는다. branch로의 merge는 pull request로만 진행한다.
merge를 진행할 때는 다음 양식을 코멘트로 작성한다.

**예시**

- Title
> [FEAT] 1-maddy-fragment

- Content
> - 메모장 구현 완료
> - ROOMDB를 통한 database 구현 완료
> - ...

## feature branch

### feature/1-main-activity
- MainActivity에서 BottomNavigation을 구현한다.
- 그 외 다른 fragment는 수정하지 않는다.
- gradle 파일은 수정하지 않는다. 만일 수정해야 한다면 미리 공지한다.

made by [wbham](https://github.com/WooBinHam)

### feature/2-maddy-fragment
- UMC standard mission week8 내용을 구현한다.
- 그 외 다른 fragment는 수정하지 않는다.
- 즉, fragment 관련 kt, xml 하나씩과 관련 _strings.xml만 수정한다.
- gradle 파일은 수정하지 않는다. 만일 수정해야 한다면 미리 공지한다.

made by [Maddy](https://github.com/MADElinessss)

### feature/3-wbham-fragment
- UMC standard mission week8 내용을 구현한다.
- 그 외 다른 fragment는 수정하지 않는다.
- 즉, fragment 관련 kt, xml 하나씩과 관련 _strings.xml만 수정한다.
- gradle 파일은 수정하지 않는다. 만일 수정해야 한다면 미리 공지한다.

made by [wbham](https://github.com/WooBinHam)

### feature/4-Jaeeepp-fragment
- UMC standard mission week8 내용을 구현한다.
- 그 외 다른 fragment는 수정하지 않는다.
- 즉, fragment 관련 kt, xml 하나씩과 관련 _strings.xml만 수정한다.
- gradle 파일은 수정하지 않는다. 만일 수정해야 한다면 미리 공지한다.

made by [jaeeepp](https://github.com/Jaeeepp)

### feature/5-Arr-fragment
- UMC standard mission week8 내용을 구현한다.
- 그 외 다른 fragment는 수정하지 않는다.
- 즉, fragment 관련 kt, xml 하나씩과 관련 _strings.xml만 수정한다.
- gradle 파일은 수정하지 않는다. 만일 수정해야 한다면 미리 공지한다.

made by [Arr](https://github.com/LeeGa00)

### feature/6-RDH-fragment
- UMC standard mission week8 내용을 구현한다.
- 그 외 다른 fragment는 수정하지 않는다.
- 즉, fragment 관련 kt, xml 하나씩과 관련 _strings.xml만 수정한다.
- gradle 파일은 수정하지 않는다. 만일 수정해야 한다면 미리 공지한다.

made by [RDH-develop](https://github.com/RDH-develop)

## Commit convention
commit message는 다음과 같이 작성하도록 한다.
- 기능 구현: "[FEAT] 변경 내용(추가된 클래스명, 추가된 함수명 등등)"
- 버그 수정: "[FIX] 변경 내용"
- 테스트: "[TEST] 테스트 코드 내용"
- 그 외는 자유롭게 작성하되 최대한 명료하게 작성한다.