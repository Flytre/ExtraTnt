import os
import shutil
from os.path import dirname

current_path = os.getcwd()
template_path = "/Users/aaron/IdeaProjects/Mod Template"
template_proguard_path = os.path.join(template_path, "proguard")

def copy(*path):
    dest = os.path.join(current_path, *path)
    parent = dirname(dest)
    if not os.path.exists(parent):
        os.makedirs(parent)
    shutil.copyfile(os.path.join(template_path, *path), dest)

shutil.rmtree(os.path.join(current_path, "proguard"), ignore_errors=True)
shutil.copytree(os.path.join(template_path, "proguard"), os.path.join(current_path, "proguard"))
copy("Common","build.gradle")
copy("Fabric","build.gradle")
copy("Forge","build.gradle")
copy("auth.properties")
copy("auth_fallback.properties")
copy("LICENSE")
copy("build.gradle")

