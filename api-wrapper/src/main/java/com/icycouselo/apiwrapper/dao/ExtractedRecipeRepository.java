package com.icycouselo.apiwrapper.dao;

import com.icycouselo.apiwrapper.entity.extractedrecipe.ExtractedRecipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtractedRecipeRepository extends MongoRepository<ExtractedRecipe, String> {
}
