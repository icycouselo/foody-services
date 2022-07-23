package com.icycouselo.apiwrapper.respository;

import com.icycouselo.apiwrapper.respository.entity.extractedrecipe.ExtractedRecipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtractedRecipeRepository extends MongoRepository<ExtractedRecipe, String> {}
