package com.veight.cms.utils;

import com.veight.cms.entities.TagModel;
import com.veight.cms.model.Tag;
/**
 * Tag
 *
 * @author youyou
 */
public class TagDTOUtils {

    public static Tag getDTO(TagModel model) {
        Tag result = null;
        if (model != null) {
            result = new Tag(
                    model.getId(),
                    model.getName());
        }
        return result;
    }

    public static TagModel converDTO(Tag tag) {
        TagModel result = null;
        if (tag != null) {
            result = new TagModel();
        }
        return result;
    }
}
