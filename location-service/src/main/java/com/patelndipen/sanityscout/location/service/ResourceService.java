package com.patelndipen.sanityscout.location.service;

import org.springframework.core.io.InputStreamResource;

public interface ResourceService {

  /**
   * Find image from server directory
   *
   * @param imagePath
   * @return InputStreamResource representation of image
   */
  InputStreamResource findPreviewByImagePath(String imagePath);

}
