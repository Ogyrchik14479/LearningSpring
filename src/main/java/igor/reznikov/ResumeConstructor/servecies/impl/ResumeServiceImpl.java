package igor.reznikov.ResumeConstructor.servecies.impl;

import igor.reznikov.ResumeConstructor.dtos.request.ResumePost;
import igor.reznikov.ResumeConstructor.dtos.response.ResumeView;
import igor.reznikov.ResumeConstructor.entities.Resume;
import igor.reznikov.ResumeConstructor.mappers.ResumeMapper;
import igor.reznikov.ResumeConstructor.repositories.ResumeRepository;
import igor.reznikov.ResumeConstructor.servecies.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    ResumeRepository resumeRepository;

    @Override
    public Long add(ResumePost resumePost) {

        Long resumeId = save(new Resume()).getId();

        resumePost.setId(resumeId);
        resumePost.getBasicInformation().setResumeId(resumeId);
        resumePost.getPersonalInformation().setResumeId(resumeId);
        resumePost.getWorkExperienceList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getEducationList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getCourseList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getAchievementList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getPublicationList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getSkillList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getLanguageList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getHobbyList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getCourseList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getCustomizableSectionList().forEach(item -> item.setResumeId(resumeId));
        resumePost.getRecommendationList().forEach(item -> item.setResumeId(resumeId));

        Resume resume = ResumeMapper.INSTANCE.toResume(resumePost);
        return resumeRepository.save(resume).getId();
    }

    private Resume save(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public ResumeView getResumeById(Long id) {
        return ResumeMapper.INSTANCE.toResumeDTO(resumeRepository.findById(id).get());
    }
}
