/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms;

import com.veight.cms.api.TagService;
import com.veight.cms.entities.TagModel;
import com.veight.cms.entities.dao.TagDao;
import com.veight.cms.model.Tag;
import com.veight.cms.utils.TagDTOUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author youyou
 */
@Remote
@Stateless
public class TagServiceBean implements TagService {

    @EJB
    TagDao TagDao;

    /**
     * @see
     * net.filippov.newsportal.service.TagService#getByName(java.lang.String)
     */
    @Override
    public Tag getByName(String name) {

        TagModel model = TagDao.getByName(name);

        return TagDTOUtils.getDTO(model);

    }

    /**
     * @see
     * net.filippov.newsportal.service.impl.AbstractServiceImpl#getAllTransactionally()
     */
    @Override
    public List<Tag> findAll() {
        List<TagModel> models = TagDao.getAll();
        List<Tag> tags = new ArrayList<Tag>(models.size());
        for (TagModel model : models) {
            tags.add(TagDTOUtils.getDTO(model));
        }
        return tags;

    }

    /**
     * @see net.filippov.newsportal.service.TagService#getAllNames()
     */
    @Override
    public List<String> getAllNames() {
        List<String> tags = TagDao.getAllNames();
        return tags;
    }

    @Override
    public String getAutocompleteJson() {
        List<String> tagNames = this.getAllNames();

        if (tagNames.isEmpty()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        for (String name : tagNames) {
            result.append("\"")
                    .append(name)
                    .append("\"")
                    .append(",");
        }
        result.delete(result.length() - 1, result.length())
                .append("]");
        return result.toString();
    }

    /**
     * @see
     * net.filippov.newsportal.service.TagService#getTagString(java.util.Set)
     */
    @Override
    public String getTagString(Set<Tag> tags) {
        StringBuilder result = new StringBuilder();
        for (Tag tag : tags) {
            result.append(tag.getName()).append(",");
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }
    
}
