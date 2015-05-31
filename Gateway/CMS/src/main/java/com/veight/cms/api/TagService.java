/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.api;

import com.veight.cms.model.Tag;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 * 标签管理
 *
 * @author youyou
 */
@Remote
public interface TagService {

    /**
     * Get tag from repository by it's name
     *
     * @param name tag name
     * @return tag
     */
    public Tag getByName(String name);

    /**
     * Get all tag names
     *
     * @return list of tags
     */
    public List<String> getAllNames();

    /**
     * findAll
     *
     * @return
     */
    public List<Tag> findAll();

    /**
     * Get json of all tag names
     *
     * @return json
     */
    public String getAutocompleteJson();

    /**
     * Get comma-separated string of tags from set of tags
     *
     * @param tags set of tags
     * @return string of tags
     */
    public String getTagString(Set<Tag> tags);
}
