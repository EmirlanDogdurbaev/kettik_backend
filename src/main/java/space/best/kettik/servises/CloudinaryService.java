package space.best.kettik.servises;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CloudinaryService {

    final Cloudinary cloudinary;


    public String upload(MultipartFile multipartFile) {
        try {
            return String.valueOf(
                    cloudinary.uploader()
                            .upload(multipartFile.getBytes(), ObjectUtils.emptyMap(
                            ))
                            .get("secure_url")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
