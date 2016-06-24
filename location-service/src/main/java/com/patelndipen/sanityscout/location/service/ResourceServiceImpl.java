package com.patelndipen.sanityscout.location.service;

import java.io.InputStream;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.InputStreamResource;

@Service
public class ResourceServiceImpl implements ResourceService {

  @Override
  public InputStreamResource findPreviewByImagePath(String imagePath) {
    ClassPathResource img = new ClassPathResource("/previews/" + imagePath);
    InputStreamResource i;

    try {
      i = new InputStreamResource(img.getInputStream());
    } catch (IOException e) {
      i = null;
    }
    return i;
  }
}
