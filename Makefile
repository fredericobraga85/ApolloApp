
installCodeGen:
	npm install -g apollo-codegen

createSchema:
	apollo-codegen download-schema http://na.herald.riotgames.com/graphql --output ./app/src/main/graphql/schema.json