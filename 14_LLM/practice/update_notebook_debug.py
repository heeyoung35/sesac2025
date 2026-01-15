import json
import os

notebook_path = 'd:/lecture/14_LLM/practice/faqtest.ipynb'

if not os.path.exists(notebook_path):
    print(f"Error: {notebook_path} not found")
    exit(1)

with open(notebook_path, 'r', encoding='utf-8') as f:
    nb = json.load(f)

# Find the cell with id="pinecone_init"
target_cell = None
for cell in nb['cells']:
    if cell.get('id') == 'pinecone_init':
        target_cell = cell
        break

if target_cell:
    target_cell['source'] = [
        "from langchain_pinecone import PineconeVectorStore\n",
        "from dotenv import load_dotenv\n",
        "import os\n",
        "\n",
        "# Force reload .env file to ensure latest keys are loaded\n",
        "load_dotenv(override=True)\n",
        "\n",
        "# Load API Key explicitly\n",
        "pinecone_api_key = os.getenv('PINECONE_API_KEY')\n",
        "print(f\"DEBUG: PINECONE_API_KEY loaded? {bool(pinecone_api_key)}\")\n",
        "\n",
        "if not pinecone_api_key:\n",
        "    print(\"Warning: PINECONE_API_KEY not found in environment variables. Please check .env file.\")\n",
        "\n",
        "# Index name\n",
        "index_name = \"skt-index\"\n",
        "\n",
        "# Upload to Pinecone\n",
        "if pinecone_api_key: \n",
        "    vectorstore = PineconeVectorStore.from_documents(\n",
        "        documents=all_documents,\n",
        "        embedding=embeddings,\n",
        "        index_name=index_name,\n",
        "        pinecone_api_key=pinecone_api_key\n",
        "    )\n",
        "    print(f\"Successfully uploaded {len(all_documents)} documents to Pinecone index '{index_name}'\")\n"
    ]
    print("Updated pinecone_init cell with load_dotenv(override=True).")

with open(notebook_path, 'w', encoding='utf-8') as f:
    json.dump(nb, f, indent=1, ensure_ascii=False)

print("Successfully updated faqtest.ipynb")
