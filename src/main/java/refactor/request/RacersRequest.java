package refactor.request;

import refactor.racer.ParticipatedRacers;

public class RacersRequest {
    private final String racersValue;

    public RacersRequest(String racersValue) {
        validateRacersValue(racersValue);
        this.racersValue = racersValue;
    }

    private void validateRacersValue(String racersValue) {
        // 검증 과정을 메서드 내 작성하기
    }

    public ParticipatedRacers toParticipatedRacers(String racersValue) {
        // racersValue split하기
        // 각 Racer.of( , 0) 으로 레이서를 생성하고 리스트로 만들기
        // 리스트를 ParticipatedRacers.of() 인자로 전달하기
        return null;
    }
}
