package com.codesite.ayushmanProject.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface IdGenerationService {

    Long generateUniqueId();
}
